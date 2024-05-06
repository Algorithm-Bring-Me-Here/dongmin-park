class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val map = HashMap<String, Int>()

        // 의상의 종류별로 개수를 세어 map에 저장
        for (cloth in clothes) {
            val type = cloth[1]
            map[type] = map.getOrDefault(type, 0) + 1
        }

        var answer = 1
        // 의상의 종류별로 (의상의 개수 + 1)을 곱하여 모든 조합의 수 계산
        for (count in map.values) {
            answer *= (count + 1)
        }

        // 모든 종류의 의상을 입지 않은 경우를 제외하기 위해 -1
        return answer - 1
    }
}
