package jimin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val m = br.readLine().toInt()
    var s = MutableList(21) { false }

    var operator = ""
    var x = 0

    repeat(m) {
        br.readLine().split(" ").apply {
            operator = first()
            x = last().toIntOrNull() ?: 0
        }

        when (operator) {
            "add" -> {
                s[x] = true
            }

            "remove" -> {
                s[x] = false
            }

            "check" -> {
                if (s[x]) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }

            "toggle" -> {
                s[x] = s[x].not()
            }

            "all" -> {
                s = MutableList(21) { true }
            }

            "empty" -> {
                s = MutableList(21) { false }
            }
        }
    }

    bw.flush()
    bw.close()
}