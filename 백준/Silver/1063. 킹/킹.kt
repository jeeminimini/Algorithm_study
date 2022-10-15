package jimin.`5week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
<문제>

<구현 방법>

<트러블 슈팅>
 */

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (king, dol, n) = readLine().split(" ")
    var kingX = king[0] - 'A'
    var kingY = king[1].toString().toInt() - 1
    var dolX = dol[0] - 'A'
    var dolY = dol[1].toString().toInt() - 1
    val movementResult = mutableListOf<String>()
    repeat(n.toInt()) {
        movementResult.add(readLine())
    }
    val movementOfKing =
        mapOf<String, Pair<Int, Int>>(
            "R" to Pair(1, 0),
            "L" to Pair(-1, 0),
            "B" to Pair(0, -1),
            "T" to Pair(0, 1),
            "RT" to Pair(1, 1),
            "LT" to Pair(-1, 1),
            "RB" to Pair(1, -1),
            "LB" to Pair(-1, -1),
        )
   
    movementResult.forEach {
        if ((kingX + (movementOfKing[it]?.first ?: 0) in 0 until 8 &&
                    kingY + (movementOfKing[it]?.second ?: 0) in 0 until 8
                    ).not()
        ) {
            return@forEach
        } else if (kingX + (movementOfKing[it]?.first ?: 0) == dolX &&
            kingY + (movementOfKing[it]?.second ?: 0) == dolY &&
            (dolX + (movementOfKing[it]?.first ?: 0) in 0 until 8 &&
                    dolY + (movementOfKing[it]?.second ?: 0) in 0 until 8).not()
        ) {
            return@forEach
        }
        kingX += movementOfKing[it]?.first ?: 0
        kingY += movementOfKing[it]?.second ?: 0
        if (kingX == dolX && kingY == dolY) {
            dolX += movementOfKing[it]?.first ?: 0
            dolY += movementOfKing[it]?.second ?: 0
        }
        //println("now: $it, king: $kingX $kingY, dol: $dolX $dolY")
    }

    println("${'A' + kingX}${kingY + 1}")
    println("${'A' + dolX}${dolY + 1}")
}
