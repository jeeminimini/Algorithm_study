class Solution {
    var answer = 1
    lateinit var clothesType: Map<String, List<String>>
    fun solution(clothes: Array<Array<String>>): Int {
        clothesType = clothes.groupBy({ it.last() }, {it.first()})
        clothesType.forEach{
            //println(it)
            answer *= (it.value.size + 1)
        }
        
        return answer - 1
     }
    
    fun getCombination(values: List<String>, num: Int, now: Int) {
        var tmp = false
        for (i in now until values.size) {
            //println("answer $answer $i")
            answer += num * clothesType[values[i]]!!.size
            getCombination(values, num * clothesType[values[i]]!!.size , i + 1)
            
            
        }
        
    }
}