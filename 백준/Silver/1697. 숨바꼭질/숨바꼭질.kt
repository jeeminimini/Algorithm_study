package jimin.`19week`

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = MutableList(100001) { false }
    if (n < k) {
        val queue = mutableListOf(Pair(n, 0))
        while (queue.isNotEmpty()) {
            val num = queue.removeAt(0)
            if (num.first * 2 == k) {
                println(num.second + 1)
                break
            } else if (num.first * 2 in 0 .. 100000 && visited[num.first * 2].not()) {
                queue.add(num.copy(first = num.first * 2, second = num.second + 1))
                visited[num.first * 2] = true
            }
            if (num.first - 1 == k) {
                println(num.second + 1)
                break
            } else if (num.first - 1 in 0 .. 100000 && visited[num.first - 1].not()) {
                queue.add(num.copy(first = num.first - 1, second = num.second + 1))
                visited[num.first - 1] = true
            }
            if (num.first + 1 == k) {
                println(num.second + 1)
                break
            } else if (num.first + 1 in 0 .. 100000 && visited[num.first + 1].not()) {
                queue.add(num.copy(first = num.first + 1, second = num.second + 1))
                visited[num.first + 1] = true
            }
        }
    } else {
        println(n - k)
    }
}

