class Solution {
    fun solution(answers: IntArray): IntArray {
        val patterns = arrayOf( // 선수들의 패턴
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        
        val scores = IntArray(3)
        
        for (i in answers.indices) {
            for (j in patterns.indices) {
                if (answers[i] == patterns[j][i % patterns[j].size]) { // 일치하는 경우 판별
                    scores[j]++
                }
            }
        }
        
        val maxScore = scores.maxOrNull() ?: 0
        
        return scores.mapIndexed { index, score ->
            if (score == maxScore) index + 1 else null
        }.filterNotNull().toIntArray()
    }
}
