package jimin.`25week`

class 톱니바퀴 {

    val wheels = mutableListOf<MutableList<Int>>()
    fun solve() {
        repeat(4) {
            wheels.add(readln().chunked(1).map { it.toInt() } as MutableList)
        }
        repeat(readln().toInt()) {
            readln().split(" ").map { it.toInt() }.apply {
                checkWheel(first(), last())
            }
        }

        println(wheels[0][0] + wheels[1][0] * 2 + wheels[2][0] * 4 + wheels[3][0] * 8)
    }

    fun checkWheel(wheelNumber: Int, direction: Int) {
        val isSamePoles = checkPoles()
        var otherDirection = direction * (-1)
        turnWheel(wheelNumber - 1, direction)
        if (wheelNumber == 1) {
            for (i in 0 until 3) {
                if (isSamePoles[i]) {
                    break
                } else {
                    turnWheel(wheelNumber + i, otherDirection)
                    otherDirection *= -1
                }
            }
        } else if (wheelNumber == 2) {
            if(isSamePoles[0].not()) {
                turnWheel(0, otherDirection)
            }
            for(i in 1 until 3) {
                if (isSamePoles[i]) {
                    break
                } else {
                    turnWheel(wheelNumber - 1 + i, otherDirection)
                    otherDirection *= -1
                }
            }
        } else if (wheelNumber == 3) {
            for(i in 1 downTo 0) {
                if (isSamePoles[i]) {
                    break
                } else {
                    turnWheel(i, otherDirection)
                    otherDirection *= -1
                }
            }
            if(isSamePoles[2].not()) {
                turnWheel(3, direction * (-1))
            }
        } else {
            for(i in 2 downTo 0) {
                if (isSamePoles[i]) {
                    break
                } else {
                    turnWheel(i, otherDirection)
                    otherDirection *= -1
                }
            }
        }
    }

    fun checkPoles(): MutableList<Boolean> {
        val isSame = mutableListOf<Boolean>()
        for (i in 0 until 3) {
            isSame.add(wheels[i][2] == wheels[i + 1][6])
        }
        return isSame
    }

    fun turnWheel(num: Int, direction: Int) {
        if (direction == 1) {
            turnRight(num)
        } else {
            turnLeft(num)
        }
    }

    fun turnRight(num: Int) {
        var prev = wheels[num][0]
        var tmp = 0
        for (i in 1 until 8) {
            tmp = wheels[num][i]
            wheels[num][i] = prev
            prev = tmp
        }
        wheels[num][0] = prev
    }

    fun turnLeft(num: Int) {
        var prev = wheels[num][7]
        var tmp = 0
        for (i in 6 downTo 0) {
            tmp = wheels[num][i]
            wheels[num][i] = prev
            prev = tmp
        }
        wheels[num][7] = prev
    }
}

fun main() {
    톱니바퀴().solve()
}