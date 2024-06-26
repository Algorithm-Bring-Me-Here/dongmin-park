class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var first = a
        var second = b

        while (first != second) {
            first = (first + 1) / 2
            second = (second + 1) / 2
            answer++
        }

        return answer
    }
}

/*
정말 직관적으로 각 라운드를 진행시켰습니다.

자신의 숫자에서 1을 더한 후 2를 나눈다면 다음 라운드의 자신의 숫자가 나오게 됩니다.
그렇게 매번 다음라운드로 진행을 하고, 언젠가 a와 b가 만나게 되는 순간에 while을 종료시켰습니다.

이때, a와 b가 대결하게 되는 경우에는 1 차이가 나는 경우입니다.
이 조건이 아닌, 둘이 같을 경우 라는 조건을 사용한 이유는 아래와 같습니다.

단순한 1의 차이일 경우 반례가 너무 많습니다.
ex) 2, 3 -> 1 vs 2 / 3 vs 4
그래서 해당 경우를 제외하기 위해 if문으로 자신이 짝수일 경우 나머지 숫자가 자신보다 1 낮을때 종료시키게 하였습니다.
하지만, 불필요한 연산이 너무 많다고 생각했습니다.
그래서 한번 더 나누기를 진행한다면 결국 같은 숫자가 되기 때문에 위와 같은 방법을 사용했습니다.
매 반복마다 if문을 진행하는 것 보다 단순한 반복문을 1회 더 시행하는 것이 연산 횟수적인 이점을 가질 것이라 생각했습니다.
*/
