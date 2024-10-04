class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        var temp = conversion(n, k).split('0').filter { it.isNotEmpty() }
    
        for (i in temp) {
            if (isSosu(i.toLong())) {
                answer++
            }
        }
        
        return answer
    }
    
    fun conversion(number: Int, N: Int): String { // 진법 변환
        var result = ""
        var current = number

        while (current > 0) {
            result += (current % N).toString()
            current /= N
        }
        
        return result.reversed()
    }

    fun isSosu(num: Long): Boolean { // 소수 판별
        if (num <= 1) return false
        if (num == 2L) return true
        if (num % 2 == 0L) return false // 밑에서 홀수만 검사하기 위해 2로 미리 검사하여 시간 단축

        val sqrtNum = kotlin.math.sqrt(num.toDouble()).toLong()
        for (i in 3..sqrtNum step 2) { // 제곱근으로 최대 값을 한정하고, step을 이용해서 홀수만 검사
            if (num % i == 0L) {
                return false
            }
        }
        return true
    }
}
