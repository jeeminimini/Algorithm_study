import java.lang.Integer.*
class Solution {
    fun solution(X: String, Y: String): String {
        var answer: String = "-1"
        var xInfo = mutableMapOf<Char, Int>()
        var yInfo = mutableMapOf<Char, Int>()
        var xAll = X.toList().distinct()
        var number = mutableListOf<Char>()
        X.forEach{ x ->
            if (x !in xInfo.keys) {
                xInfo[x] = 1
            } else {
                xInfo[x] = xInfo[x]!! + 1
            }
        }
        
        Y.forEach{ y ->
            if (y !in yInfo.keys) {
                yInfo[y] = 1
            } else {
                yInfo[y] = yInfo[y]!! + 1
            }
        }
        
        xAll.forEach{ x->
            var num = min(xInfo.getOrDefault(x, 0), yInfo.getOrDefault(x, 0))
            if (num != 0) {
                repeat(num) {
                    number.add(x)
                }
            }
        }
        number.sortDescending()
        //println(number)
        if (number.isNotEmpty()) {
            if (number.all{ it == '0'}) {
                answer = "0"
            } else {
                answer = number.joinToString("")
            }
        }
        
        return answer
    }
}