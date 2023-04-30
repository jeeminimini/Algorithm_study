package jimin.`31week`

class 이모티콘 {
    var s = 0
    var operator = listOf(COPY, PASTE, DELETE)
    fun solve() {
        s = readln().toInt()

        bfs()
    }

    fun bfs() {
        val queue = ArrayDeque<List<Int>>()
        val visited = MutableList(MAX){ MutableList(MAX) { false } }
        queue.addLast(listOf(COPY, 1, 0, 0))
        visited[1][0] = true

        while (queue.isNotEmpty()) {
            var (now, nScreen, nClipboard, nTime) = queue.removeFirst()
            when (now) {
                COPY -> {
                    nClipboard = nScreen
                }
                PASTE -> {
                    nScreen += nClipboard
                }
                DELETE -> {
                    nScreen -= 1
                }
            }
            nTime += 1
            if (visited[nScreen][nClipboard]) {
                continue
            }
            visited[nScreen][nClipboard] = true
            if (nScreen == s) {
                println(nTime)
                break
            }

            if (nScreen in 1 until MAX) {
                queue.addLast(listOf(COPY, nScreen, nScreen, nTime))
            }
            if (nClipboard > 0 && nScreen + nClipboard < MAX) {
                queue.addLast(listOf(PASTE, nScreen, nClipboard, nTime))
            }
            if (nScreen in 1 until MAX) {
                queue.addLast(listOf(DELETE, nScreen, nClipboard, nTime))
            }

        }
    }

    companion object {
        const val COPY = 0
        const val PASTE = 1
        const val DELETE = 2
        const val MAX = 2000
    }
}

fun main() {
    이모티콘().solve()
}


//while (queue.isNotEmpty()) {
//    val (nScreen, nClipboard, nTime) = queue.removeFirst()
//
//    if (nScreen == s) {
//        println(nTime)
//        break
//    }
//
//    if (visited[nScreen][nClipboard]) {
//        continue
//    }
//    if (nScreen in 0 until MAX) {
//
//        queue.addLast(listOf(nScreen, nScreen, nTime + 1))
//    }
//    if (nClipboard > 0 && nScreen + nClipboard < MAX) {
//        queue.addLast(listOf(nScreen + nClipboard, nClipboard, nTime + 1))
//    }
//    if (nScreen in 0 until MAX) {
//        queue.addLast(listOf(nScreen - 1, nClipboard, nTime + 1))
//    }
//
//}