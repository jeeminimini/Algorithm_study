package jimin.`25week`

class 오큰수 {
    fun solve() {
        val n = readln().toInt()
        val numbers = readln().split(" ").map{ it.toInt() } as MutableList
        val stack = ArrayDeque<Int>()
        numbers.forEachIndexed{ idx,  num ->
            while (stack.isNotEmpty() && numbers[stack.first()] < num) {
                numbers[stack.removeFirst()] = num
            }
            stack.addFirst(idx)
        }
        stack.forEach{
            numbers[it] = -1
        }
        println(numbers.joinToString(" "))
    }
}

fun main() {
    오큰수().solve()
}