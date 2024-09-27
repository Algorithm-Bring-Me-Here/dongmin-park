class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        
        for(i in 1 .. number) {
            val count = counter(i)
            
            if (count > limit) { // 리미트보다 더 크다면 power 만큼 추가
                answer += power;
            } else { // 리미트보다 작거나 같다면 해당 숫자만큼 추가
                answer += count;
            }
        }
        
        return answer
    }

    // 소수 구하기
    private fun counter(num: Int): Int {
        var count = 0

        for (i in 1..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) {
                count++
                if (i != num / i) {
                    count++
                }
            }
        }
        return count
    }
}
