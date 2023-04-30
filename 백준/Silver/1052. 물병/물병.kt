package jimin.`31week`

class 물병 {
    fun solve(){
        var (n, k) = readln().split(" ").map{ it.toInt() }
        var result = 0

        while (true) {
            var newN = n
            var cnt = 0
            while(newN > 0) {
                if (newN % 2 != 0) {
                    cnt += 1
                }
                newN /= 2
            }
            if (cnt <= k) {
                break
            }
            result += 1
            n += 1
        }
        println(result)
    }
}

fun main() {
    물병().solve()
}