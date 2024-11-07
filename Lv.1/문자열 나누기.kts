class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        
        var sameCount = 1
        var differentCount = 0
        
        var first: Char? = s[0]
        
        for(i in 1 until s.length) {
            if(first == null) {
                first = s[i]
                sameCount++
            } else if(first == s[i]) {
                sameCount++
            } else {
                differentCount++
            }
            
            if(sameCount == differentCount) {
                sameCount = 0
                differentCount = 0
                first = null
                
                answer++
            }
        }
        
        if(first != null) {
            answer++
        }
        
        return answer
    }
}
