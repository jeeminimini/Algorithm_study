package jimin.`29week`

import kotlin.math.*

class `상어 초등학교` {
    private lateinit var seats: MutableList<MutableList<Int>>
    private val dx = mutableListOf(0, 0, -1, 1)
    private val dy = mutableListOf(1, -1, 0, 0)
    fun solve() {
        val n = readln().toInt()
        seats = MutableList(n) { MutableList(n) { 0 } }
        val students = mutableListOf<List<Int>>()
        var result = 0
        repeat(n * n) {
            var student = 0
            lateinit var likes: List<Int>
            readln().split(" ").map { it.toInt() }.apply {
                student = first()
                likes = this.drop(1)
                students.add(this)
            }

            setSeat(n, student, likes)
        }

        students.sortBy { it[0] }

        for (i in 0 until n) {
            for (j in 0 until n) {
                var num = 0
                for (k in 0 until 4) {
                    if (i + dx[k] in 0 until n && j + dy[k] in 0 until n &&
                            seats[i + dx[k]][j + dy[k]] in students[seats[i][j] - 1]){
                        num += 1
                    }
                }
                result += if (num == 0) 0 else 10.0.pow(num - 1).toInt()
            }
        }

        println(result)
    }

    private fun setSeat(n: Int, student: Int, likes: List<Int>) {
        var bestNum = Pair(-1, -1)
        var bestSeat = Pair(-1, -1)
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (seats[i][j] == EMPTY) {
                    var likeNum = 0
                    var emptyNum = 0
                    for (k in 0 until 4) {
                        if (i + dx[k] in 0 until n && j + dy[k] in 0 until n) {
                            if (seats[i + dx[k]][j + dy[k]] in likes) {
                                likeNum++
                            } else if (seats[i + dx[k]][j + dy[k]] == EMPTY) {
                                emptyNum++
                            }
                        }
                    }
                    if (bestNum.first < likeNum || (bestNum.first == likeNum && bestNum.second < emptyNum)) {
                        bestNum = Pair(likeNum, emptyNum)
                        bestSeat = Pair(i, j)
                    }
                }
            }
        }
        seats[bestSeat.first][bestSeat.second] = student
    }

    companion object {
        private const val EMPTY = 0
    }
}

fun main() {
    `상어 초등학교`().solve()
}