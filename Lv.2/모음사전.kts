class Solution {
    fun solution(word: String): Int {
        var answer = 0
        val alphabet = mapOf(
            'A' to 0,
            'E' to 1,
            'I' to 2,
            'O' to 3,
            'U' to 4
        )
        
        // 자리수별 가중치
        val weights = intArrayOf(781, 156, 31, 6, 1)
        
        word.forEachIndexed { index, value -> 
            answer += (alphabet[value] ?: 0) * weights[index] + 1
        }
        
        return answer
    }
}
