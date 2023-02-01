package jimin.`21week`

class 부등호 {
    var n = 0
    lateinit var signs: List<String>
    val result = mutableListOf<String>()
    fun solve() {
        n = readln().toInt()
        signs = readln().split(" ")

        repeat(10) {
            getNumber(mutableListOf(it))
        }

        println(result.maxOf{ it })
        println(result.minOf{ it })
    }

    fun getNumber(numbers: MutableList<Int>) {
        if (numbers.size == n + 1) {
            result.add(numbers.joinToString(""))
            return@getNumber
        }

        for (i in 0..9) {
            if (i !in numbers &&
                ((signs[numbers.size - 1] == ">" && numbers[numbers.size - 1] > i) ||
                (signs[numbers.size - 1] == "<" && numbers[numbers.size - 1] < i))
            ) {
                numbers.add(i)
                getNumber(numbers)
                numbers.removeLast()
            }
        }
    }

}

fun main() {
    부등호().solve()
}