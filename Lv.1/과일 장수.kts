class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0

        score.sortDescending()
        val boxs = score.size / m 
        
        for(i in 1 .. boxs) {
            answer += (score[m * i - 1]) * m
        }
        
        return answer
    }
}

/*

score.sortDescending()
-> 가장 큰 금액을 벌기 위해서는 비싼 사과부터 포장해야 남는 사과가 저렴한 사과이기 때문에 최대의 돈을 벌 수 있어요.
그렇기 때문에 큰 숫자대로 정렬한다면 최대의 가격을 구할 수 있어요

val boxs = score.size / m 
-> 한 박스에 들어가는 사과의 가치는 가장 낮은 가격의 사과로부터 결정돼요. 
즉, 가장 마지막에 넣는 사과의 가치가 그 박스의 가치를 결정하기 때문에 마지막에 넣은 사과의 가격을 제외한 다른 사과의 가격은 몰라도 돼요.

for(i in 1 .. boxs) {
  answer += (score[m * i - 1]) * m
}
-> 정렬된 score에서 한 박스르 만들 때 마다 마지막에 넣은 사과의 가격에 사과의 갯수를 더해서 한 박스의 가격을 구하고 있어요.
box의 갯수만큼 반복하며 총 금액을 구해요
*/
