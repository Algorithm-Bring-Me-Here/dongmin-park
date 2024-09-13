import kotlin.math.* // abs를 사용하기 위해 추가

class Solution {
    private val keypad = mapOf( // 키패드에 해당하는 index 할당
        1 to Pair(0, 0), 2 to Pair(0, 1), 3 to Pair(0, 2),
        4 to Pair(1, 0), 5 to Pair(1, 1), 6 to Pair(1, 2),
        7 to Pair(2, 0), 8 to Pair(2, 1), 9 to Pair(2, 2),
        0 to Pair(3, 1)
    )

    // 두 점사이의 거리를 측정하는 확장함수
    private fun getDistance(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>): Int = abs(pos1.first - pos2.first) + abs(pos1.second - pos2.second)
    
    fun solution(numbers: IntArray, hand: String): String {
        var left = Pair(3, 0) // 왼손의 시작점(*)
        var right = Pair(3, 2) // 오른손의 시작점(#)
        var answer = ""
        
        for (number in numbers) {
            when (number) {
                1, 4, 7 -> { // 무조건 왼손이 움직이는 경우
                    answer += "L"
                    left = keypad[number]!!
                }
                3, 6, 9 -> { // 무조건 오른손이 움직이는 경우
                    answer += "R"
                    right = keypad[number]!!
                }
                else -> {
                    val target = keypad[number]!! // 움직여야 하는 번호
                    val leftDist = getDistance(left, target) // 왼손과 해당 값과의 거리
                    val rightDist = getDistance(right, target) // 오른손과 해당 값과의 거리

                    if (leftDist < rightDist || (leftDist == rightDist && hand == "left")) {
                        // 왼손이 더 가까운 경우 || 양손이 거리가 같지만, 왼손잡이인 경우
                        answer += "L"
                        left = target
                    } else {
                        // 오른손이 더 가까운 경우 || 양손이 거리가 같지만, 오른손잡이인 경우
                        answer += "R"
                        right = target
                    }
                }
            }
        }
        
        return answer
    }
}
