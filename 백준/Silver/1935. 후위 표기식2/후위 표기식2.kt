package jimin.`9week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import java.util.Stack

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val formula = readLine()
    val formulaInfo = mutableMapOf<Char, Double>()
    repeat(n){
        formulaInfo['A' + it] = readLine().toDouble()
    }
    val stack = Stack<Double>()
    formula.forEach {
        if (it in 'A'..'Z'){
            stack.push(formulaInfo[it])
        } else {
            val second = stack.pop()
            val first = stack.pop()
            when (it) {
                '*' -> {
                    stack.push(first * second)
                }
                '/' -> {
                    stack.push(first / second)
                }
                '+' -> {
                    stack.push(first + second)
                }
                '-' -> {
                    stack.push(first - second)
                }
            }
        }
    }
    println(DecimalFormat(".00").format(stack.pop()))

}