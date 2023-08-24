package jimin.`42week`

/*
<문제>
[블로그](https://www.acmicpc.net/problem/21921)

<구현 방법>

<트러블 슈팅>
 */

class 블로그 {
    fun solve() {
        val (n, x) = readln().split(" ").map{ it.toInt() }
        val people = readln().split(" ").map{ it.toInt() }
        var sum = people.subList(0, x).sumOf{ it }
        var maxi = sum
        var maxiNum = 1

        for(i in 1 .. n - x){
            val new = sum - people[i - 1] + people[i + x - 1]
            if (maxi < new) {
                maxi = new
                maxiNum = 1
            } else if (maxi == new) {
                maxiNum += 1
            }
            sum = new
        }

        if (maxi == 0) {
            println("SAD")
        } else {
            println(maxi)
            println(maxiNum)
        }
    }
}

fun main() {
    블로그().solve()
}