package jimin.`41week`

class `개미의 이동` {
    fun solve() {
        val (l, t) = readln().split(" ").map { it.toInt()}
        val n = readln().toInt()
        val ants = mutableListOf<Int>()
        repeat(n) {
            readln().split(" ").apply {
                if (last() == "L") {
                    val move = t + l - first().toInt()
                    if(move < l) {
                        ants.add(l - move)
                    } else {
                        if ((move / l) % 2 == 1) {
                            ants.add(move % l)
                        } else {
                            ants.add(l - move % l)
                        }
                    }
                } else {
                    val move = t + first().toInt()
                    if(move < l) {
                        ants.add(move)
                    } else {
                        if ((move / l) % 2 == 1) {
                            ants.add(l - move % l)
                        } else {
                            ants.add(move % l)
                        }
                    }
                }
            }
        }
        println(ants.sorted().joinToString(" "))
    }
}

fun main() {
    `개미의 이동`().solve()
}