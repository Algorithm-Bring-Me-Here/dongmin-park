class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        var person: CharArray = charArrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
        var score: IntArray = IntArray(8) { 0 }

        for (i in survey.indices) {
            score[person.indexOf(survey[i][1])] += choices[i] - 4
        }

        for (i in 0..7 step 2) {
            if (score[i] >= score[i + 1]) answer += person[i]
            else answer += person[i + 1]
        }
        return answer
    }
}
