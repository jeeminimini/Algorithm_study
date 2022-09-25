
import kotlin.math.max
import kotlin.math.min

fun main() {
    val num = readln().split(" ").map { it.toInt() }
    val rectList = arrayListOf<List<Int>>()
    for (i in 0 until num[0]) {
        rectList.add(readln().chunked(1).map { it.toInt() })
    }
    val rectMax = min(num[0], num[1])
    var maxSize = 1
    for (i in 0 until num[0]) {
        for (j in 0 until num[1]) {
            for (k in 1 until rectMax) {
                if (j + k < num[1] && rectList[i][j] == rectList[i][j + k]) {
                    if (i + k < num[0] && rectList[i][j] == rectList[i + k][j]) {
                        if (rectList[i][j] == rectList[i + k][j + k]) {
                            maxSize = max(maxSize, (k + 1) * (k + 1))
                        }
                    }
                }
            }
        }
    }

    println(maxSize)
}