package jimin.`42week`

class 로또 {
    fun solve() {
        while (true) {
            val lottos = readln().split(" ").map{ it.toInt() }
            if (lottos.first() == 0) {
                break
            } else {
                printCombi(lottos.drop(1), listOf(), 0)
                println()
            }
        }

    }

    private fun printCombi(nums: List<Int>, picks: List<Int>, n:Int) {
        if (picks.size == 6) {
            println(picks.joinToString(" "))
            return@printCombi
        }
        if (n == nums.size) {
            return@printCombi
        }
        val newPicks = picks.plus(nums[n])
        printCombi(nums, newPicks, n + 1)
        printCombi(nums, picks, n + 1)

    }
}

fun main() {
    로또().solve()
}