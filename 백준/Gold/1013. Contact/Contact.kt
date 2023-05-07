package jimin.`34week`

class Contact {
    fun solve() {
        repeat(readln().toInt()) {
            val str = readln().chunked(1)
            var idx = 0
            var isRight = true
            while (idx < str.size) {
                if (idx + 1 < str.size && str[idx] == "0" && str[idx + 1] == "1") {
                    idx += 2
                } else if (idx + 2 < str.size && str[idx] == "1" && str[idx + 1] == "0" && str[idx + 2] == "0") {
                    idx += 3
                    while (idx < str.size && str[idx] == "0") {
                        idx += 1
                    }
                    if (idx >= str.size || str[idx] != "1") {
                        isRight = false
                        //println("isRight 1 $isRight $idx")
                        break
                    }
                    while (idx < str.size && str[idx] == "1") {
                        idx += 1
                    }
                    if (idx + 1 < str.size && str[idx - 2] == "1" && str[idx - 1] == "1" && str[idx] == "0" && str[idx + 1] == "0") {
                        idx -= 1
                    }
                } else {
                    isRight = false
                    break
                }
                //println("idx $idx")
            }

            if (isRight) {
                println("YES")
            } else {
                println("NO")
            }

        }
    }
}

fun main() {
    Contact().solve()
}