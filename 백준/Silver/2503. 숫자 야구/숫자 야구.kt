fun main() {
    val baseballInfoList = arrayListOf<List<Any>>()
    var totalBaseball = mutableListOf<List<Int>>()
    for (i in 1..9) {
        for (j in 1..9) {
            for (k in 1..9) {
                if (setOf(i, j, k).size == 3) {
                    totalBaseball.add(listOf(i, j, k))
                }
            }
        }
    }
    repeat(readln().toInt()) {
        baseballInfoList.add(readln().split(" ").map { it.toInt() })
    }

    val realBaseballList = arrayListOf<String>()
    for (baseball in totalBaseball) {
        var possible = 0
        for (info in baseballInfoList) {
            var strike = 0
            var ball = 0
            val guessed = info[0].toString().chunked(1).map { it.toInt() }
            for (i in guessed.indices) {
                if (guessed[i] == baseball[i]) strike += 1
                else if (guessed[i] in baseball) ball += 1
            }
            if (info[1] == strike && info[2] == ball) possible += 1
        }
        if (possible == baseballInfoList.size) realBaseballList.add(baseball.joinToString(""))
    }
    
    println(realBaseballList.size)
}