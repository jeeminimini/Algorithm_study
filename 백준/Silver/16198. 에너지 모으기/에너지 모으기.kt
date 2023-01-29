package jimin.`20week`

import java.lang.Integer.max

class `에너지 모으기` {
    var result = 0
    fun solve() {
        val n = readln().toInt()
        val energy = readln().split(" ").map{ it.toInt() }.toMutableList()

        getEnergy(energy, 0)
        println(result)

    }

    fun getEnergy(energy: List<Int>, sum: Int) {
        if (energy.size == 2) {
            result = max(result, sum)
            return
        }

        for(i in 1 until energy.size - 1) {
            getEnergy(energy.subList(0, i) + energy.subList(i+1, energy.size), sum + energy[i - 1] * energy[i + 1])
        }
    }
}

fun main() {
    `에너지 모으기`().solve()
}