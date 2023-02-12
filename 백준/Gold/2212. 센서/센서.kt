package jimin.`23week`

class 센서 {
    fun solve() {
        val n = readln().toInt()
        val k = readln().toInt()
        val sensors = readln().split(" ").map { it.toInt() }.sorted()
        var distances = mutableListOf<Pair<Int, Int>>()

        if (n <= k) {
            println(0)
            return
        }

        for(i in 1 until n) {
            distances.add(Pair(i - 1, sensors[i] - sensors[i - 1]))
        }
        distances.sortByDescending { it.second }
        distances = (distances.subList(0, k - 1) + mutableListOf(Pair(n - 1, 0))) as MutableList
        distances.sortBy{ it.first }
        var result = 0

        distances.forEachIndexed{ idx, d ->
            result += if (idx == 0) {
                sensors[d.first] - sensors[0]
            } else {
                sensors[d.first] - sensors[distances[idx - 1].first + 1]
            }
        }

        println(result)
    }
}

fun main() {
    센서().solve()
}