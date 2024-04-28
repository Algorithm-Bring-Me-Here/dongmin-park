class Solution {
    fun dfs(numbers: IntArray, target: Int, index: Int, num: Int, size: Int): Int {
        return if(index == size) { // 마지막에 도달했을 경우 맞으면 1, 틀리면 0을 반환
            if(target == num) 1 else 0
        } else { // 모든 경우를 dfs로 탐색
            dfs(numbers, target, index + 1, num + numbers[index], size) + dfs(numbers, target, index + 1, num - numbers[index], size)
        }
    }

    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0, numbers.size)
    }
}
