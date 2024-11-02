class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var distance: Int = 0
        
        section.forEachIndexed{ index, value ->
            if(distance < value) {
                distance = section[index] + m - 1;
                answer++
            }
        }
        
        return answer
    }
}
