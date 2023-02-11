package jimin.`22week`

class ABCDE {
    private lateinit var friends: MutableList<MutableList<Int>>
    private var n: Int = 0
    private var m: Int = 0
    private var result = 0
    fun solve() {
        readln().split(" ").map { it.toInt() }.apply{
            n = first()
            m = last()
        }
        friends = MutableList(n) { mutableListOf() }
        repeat(m) {
            readln().split(" ").map { it.toInt() }.apply{
                friends[first()].add(last())
                friends[last()].add(first())
            }
        }

        for(i in 0 until n) {
            dfs(mutableListOf(i))
            if (result == 1) {
                break
            }
        }

        println(result)
    }

    fun dfs(visited: MutableList<Int>) {
        if (visited.size == 5) {
            result = 1
            return
        }

        friends[visited.last()].forEach {
            if (it !in visited) {
                //("${visited.last()} $visited ${friends[visited.last()]}")
                dfs(visited.plus(it) as MutableList)
            }
        }
    }
}

fun main() {
    ABCDE().solve()
}