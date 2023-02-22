package jimin.`24week`

import kotlin.math.*

class 도서관 {
    fun solve() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val books = readln().split(" ").map{ it.toInt() }.sorted()
        var minusBooks = books.filter{ it < 0 }.map{ it * (-1) }
        var plusBooks = books.filter{ it > 0 }.reversed()
        var result = max(minusBooks.maxOrNull() ?: 0, plusBooks.maxOrNull() ?: 0) * (-1)

        //println("minus $minusBooks plus $plusBooks")

        while(minusBooks.isNotEmpty()) {
            if (minusBooks.size >= m) {
                result += minusBooks.first() * 2
                minusBooks = minusBooks.drop(m)
            } else {
                result += minusBooks.first() * 2
                break
            }
        }

        while(plusBooks.isNotEmpty()) {
            if (plusBooks.size >= m) {
                result += plusBooks.first() * 2
                plusBooks = plusBooks.drop(m)
            } else {
                result += plusBooks.first() * 2
                break
            }
        }

        println(result)
    }
}

fun main() {
    도서관().solve()
}