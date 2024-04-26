class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        val lottoMap: HashMap<Int, Int> = hashMapOf( // 랭크 반환 map 선언
            6 to 1,
            5 to 2,
            4 to 3,
            3 to 4,
            2 to 5,
            1 to 6,
            0 to 6
        )

        val zero = lottos.count { it == 0 } // 0의 갯수 체크
        val now = lottos.count { win_nums.contains(it) } // 맞는 로또 번호 갯수 체크

        answer = answer.plus(lottoMap[now + zero] ?: 0 ) // 최대 등수
        answer = answer.plus(lottoMap[now] ?: 0) // 최소 등수

        return answer
    }
}
