class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        var typeScore = mutableMapOf('R' to 0, 'T' to 0, 'C' to 0, 'F' to 0,
                                    'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0)
        for(i in 0 until survey.size) {
            if (choices[i] < 4) {
                typeScore[survey[i].first()] = typeScore[survey[i].first()]!! + 4 - choices[i]
            } else {
                typeScore[survey[i].last()] = typeScore[survey[i].last()]!! + choices[i] % 4
            }
        }
        
        if (typeScore['R']!! >= typeScore['T']!!) {
            answer += "R"
        } else {
            answer += "T"
        }
        if (typeScore['C']!! >= typeScore['F']!!) {
            answer += "C"
        } else {
            answer += "F"
        }
        if (typeScore['J']!! >= typeScore['M']!!) {
            answer += "J"
        } else {
            answer += "M"
        }
        if (typeScore['A']!! >= typeScore['N']!!) {
            answer += "A"
        } else {
            answer += "N"
        }
        
        return answer
    }
}