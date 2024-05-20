class Solution {
    fun solution(nums: LongArray): LongArray {
        val ans = LongArray(nums.size)
        var idx = 0
        for (num in nums) {
            var number = num
            for (i in generateSequence(1L) { it shl 1 }) {
                if ((number and i) == 0L) {
                    number = number or i
                    number = number xor (i shr 1)
                    break
                }
            }
            ans[idx++] = number
        }
        return ans
    }
}
