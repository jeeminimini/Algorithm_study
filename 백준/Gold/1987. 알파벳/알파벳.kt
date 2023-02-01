package jimin.`21week`

/*
<문제>
[알파벳](https://www.acmicpc.net/problem/1244)

<구현 방법>

<트러블 슈팅>
*/

import java.lang.Integer.max

class 알파벳 {
    private val dx = mutableListOf(0, 0, 1, -1)
    private val dy = mutableListOf(1, -1, 0, 0)
    private var result = 1
    private lateinit var board: MutableList<MutableList<Char>>
    private val ASCII_A = 65

    fun solve() {
        val (c, r) = readln().split(" ").map { it.toInt() }
        board = MutableList(c + 2) { MutableList(r + 2) { '.' } }
        for (i in 0 until c) {
            readln().forEachIndexed { j, alphabet ->
                board[i + 1][j + 1] = alphabet
            }
        }
        dfs(1, 1, 1, MutableList(26) { false })
        println(result)
    }

    fun dfs(x: Int, y: Int, sum: Int, visitedAlphabet: MutableList<Boolean>) {
        visitedAlphabet[board[x][y].toInt() - ASCII_A] = true
        result = max(result, sum)

        for (i in 0 until 4) {
            if (board[x + dx[i]][y + dy[i]] != '.' && visitedAlphabet[board[x + dx[i]][y + dy[i]].toInt()  - ASCII_A].not()) {
                dfs(x + dx[i], y + dy[i], sum + 1, visitedAlphabet.toMutableList())
            }
        }
    }
}

fun main() {
    알파벳().solve()
}