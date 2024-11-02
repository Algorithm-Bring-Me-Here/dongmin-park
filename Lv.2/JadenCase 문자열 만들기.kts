class Solution {
    fun solution(s: String): String {
        val answer = StringBuilder() // 시간초과 나길래 이거 썼어요
        val sentences = s.split(" ")

        sentences.forEachIndexed { index, sentence ->
            if (sentence.isNotEmpty()) {
                val formattedSentence = if (sentence[0].isDigit()) { // 숫자로 시작할 경우 뒷부분 lower case
                    sentence[0] + sentence.substring(1).toLowerCase()
                } else { // 영어라면 맨 앞만 Upper하고, 뒤는 Lower
                    sentence[0].toUpperCase() + sentence.substring(1).toLowerCase()
                }
                answer.append(formattedSentence) 
            }

            if (index != sentences.lastIndex) { // 맨 마지막 제외하고 스페이스 추가
                answer.append(" ")
            }
        }
        
        return answer.toString()
    }
}
