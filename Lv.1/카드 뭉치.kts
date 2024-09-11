class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cards1Size = cards1.size
        var cards2Size = cards2.size
        var cards1Index = 0
        var cards2Index = 0
        
        for (target in goal) {
            if (cards1Index < cards1Size && cards1[cards1Index] == target) {
                cards1Index++
            } else if (cards2Index < cards2Size && cards2[cards2Index] == target) {
                cards2Index++
            } else {
                return "No"
            }
        }
        
        return "Yes"
    }
}

/*
var cards1Size = cards1.size
반복문에서 매번 길이를 구한다면 불필요한 메모리가 사용되기 때문에 미리 길이를 구해요


var cards1Index = 0
현재 Index를 저장하는 역할을 해요. 앞에서부터 순서대로 등장해야 하기 때문에 현재 index가 중요해요


if (cards1Index < cards1Size && cards1[cards1Index] == target)
indexOutOfBounds를 막기위해 먼저 길이를 검사해요. 첫번째 조건에서 false일 경우 두번째 조건은 검사를 하지 않기 때문에 오류에서 자유로워요.


else {
  return "No"
}
early return을 사용해서 불필요한 연산을 하지 않도록 했어요


return "Yes"
for문을 전부 지나갔다는 것은 주어진 조건을 통과한 것이기 때문에 바로 Yes를 return해요.
불필요한 result 변수 하나를 줄여 메모리를 아껴요.

*/
