package jimin.`1week`

fun main() {
    val x = readLine()!!.trim().split(" ").first().toInt()
    val pixel = arrayListOf<ArrayList<Int>>()
    for (i in 0 until x) {
        pixel.add(readLine()!!.trim().split(" ").map { it.toInt() }
                as ArrayList<Int>)
    }

    val T = readLine()!!.trim().toInt()

    println(checkPixelOverT(pixel, T))
}

private fun checkPixelOverT(pixel: ArrayList<ArrayList<Int>>, T: Int): Int {
    val ninePixels = arrayListOf<Int>()
    var num = 0
    for (i in 0 until pixel.size - 2) {
        for (j in 0 until pixel[0].size - 2) {
            for (x in 0 until 3) {
                for (y in 0 until 3) {
                    ninePixels.add(pixel[i + x][j + y])
                }
            }
            if (ninePixels.sorted()[4] >= T) num += 1
            ninePixels.clear()
        }
    }
    return num
}
