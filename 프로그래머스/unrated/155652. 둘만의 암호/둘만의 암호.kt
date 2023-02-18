class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer = StringBuilder()
        s.forEach{
            var tmp = it.toInt() + 1
            var num = 0
            while (num < index) {
                //println("$tmp $num ${(97 + (tmp - 97) % 26)}")
                if((97 + (tmp - 97) % 26).toChar() in skip) {
                    tmp += 1
                } else {
                    tmp += 1
                    num += 1
                }
            }
            //println("end $tmp $num ${(97 + ((tmp - 1) - 97) % 26)}")
            answer.append((97 + ((tmp - 1) - 97) % 26).toChar())
            println(answer)
        }
        return answer.toString()
    }
}