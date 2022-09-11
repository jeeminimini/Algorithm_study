fun main() {
    val searchString = readLine()
    val num = readLine()?.toInt()
    var rings = arrayListOf<String>()
    var sum = 0
    for (i in 0 until num!!) {
        rings.add(readLine().toString())
        val check = searchStrings(searchString.toString(), rings.last())
        //println(check)
        if (check) sum += 1
    }
    print(sum)
}

fun searchStrings(search: String, ring: String): Boolean {
    //println("case: $ring")
    var matchCheck = 0
    var tmp = 0
    for (i in ring.indices) {
        if (ring[i] == search[0]) {
            for (j in search.indices) {
                tmp = j
                if (i + j < ring.length && ring[i + j] == search[j]) {
                    matchCheck += 1
                    if (matchCheck == search.length) return true
                }else break
            }
            if (matchCheck != 0){
                for (j in tmp until search.length){
                    if (ring[j - tmp] == search[j]){
                        matchCheck += 1
                    }
                    if (matchCheck == search.length) return true
                }
            }
        }
        matchCheck = 0
    }
    return false
}
//BCADEBCABC