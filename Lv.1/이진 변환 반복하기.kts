class Solution {
    fun solution(s: String): IntArray {
        var binary = s
        var count = 0
        var zeroCount = 0

        while (binary != "1") { // 종료조건
            val beforeLen = binary.length 
            binary = binary.replace("0", "")
            val afterLen = binary.length

            zeroCount += (beforeLen - afterLen)
            binary = Integer.toBinaryString(afterLen)
            count++
        }

        return intArrayOf(count, zeroCount)
    }
}
