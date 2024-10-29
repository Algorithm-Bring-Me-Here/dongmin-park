class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        val n = nums.size

      // 모든 경우의 수를 탐색
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    val sum = nums[i] + nums[j] + nums[k]
                    if (isPrime(sum)) {
                        answer++
                    }
                }
            }
        }

        return answer
    }

    // 소수인지 판별
    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false // 2 미만일 경우(1인 경우) 제외
        if (num % 2 == 0) return false // 짝수인 경우 제외

        for (i in 3..Math.sqrt(num.toDouble()).toInt() step 2) { // 홀수만 검토 하여 속도 단축
            if (num % i == 0) return false
        }

        return true
    }
}
