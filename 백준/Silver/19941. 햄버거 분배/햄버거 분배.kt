package jimin.`10week`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
<문제>
[햄버거 분배](https://www.acmicpc.net/problem/19941)

<구현 방법>
위와 오른쪽으로 가는 경우에 n만큼 증가한다고하면,
아래와 왼쪽으로 가는 경우는 n+1 만큼 증가한다.

<트러블 슈팅>
1의 위치를 알고자 할때는 while문 안에서 갱신이 안된다는 것을 미쳐 파악하지 못해서 틀렸었다.
처음에 초기화해줄때 1의 위치로 하니 맞았다.
 */

var num = 0
fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (_, size) = readLine().split(" ").map { it.toInt() }
    val line = readLine().chunked(1).toMutableList()
    line.forEachIndexed { index, s ->
        if (s == "H") {
            when (index) {
                0 -> {
                    checkBack(line, index, min(size, line.size - 1))
                }
                line.size - 1 -> {
                    checkFront(line, index, min(size, line.size - 1))
                }
                else -> {
                    if (checkFront(line, index, min(size, index)).not()){
                        checkBack(line, index, min(size, line.size - 1 - index))
                    }
                }
            }
            //println("num $num index $index")
            //println("line $line index $index num $num")
        }

    }
    println(num)
}

fun checkBack(line: MutableList<String>, index: Int, size: Int): Boolean {
    for (i in 1 .. size){
        if (line[index + i] == "P") {
            line[index + i] = "X"
            num += 1
            return true
        }
    }
    return false
}

fun checkFront(line: MutableList<String>, index: Int, size: Int): Boolean {
    for (i in size downTo 1){
        if (line[index - i] == "P") {
            line[index - i] = "X"
            num += 1
            return true
        }
    }
    return false
}