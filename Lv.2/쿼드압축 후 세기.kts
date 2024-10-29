class Solution {
    // 0과 1의 개수를 저장할 변수
    private var countZero = 0
    private var countOne = 0
    
    fun solution(arr: Array<IntArray>): IntArray {
        compress(arr, 0, 0, arr.size)
        return intArrayOf(countZero, countOne)
    }
    
    // 영역이 모두 같은 값인지 확인하는 함수
    private fun checkArea(arr: Array<IntArray>, row: Int, col: Int, size: Int): Boolean {
        val value = arr[row][col]
        for (i in row until row + size) {
            for (j in col until col + size) {
                if (arr[i][j] != value) return false
            }
        }
        return true
    }
    
    // 재귀적으로 영역을 압축하는 함수
    private fun compress(arr: Array<IntArray>, row: Int, col: Int, size: Int) {
        // 현재 영역이 모두 같은 값인지 확인
        if (checkArea(arr, row, col, size)) {
            // 같은 값이면 해당 값의 카운트 증가
            if (arr[row][col] == 0) countZero++ else countOne++
            return
        }
        
        // 영역을 4등분
        val newSize = size / 2
        // 왼쪽 위
        compress(arr, row, col, newSize)
        // 오른쪽 위
        compress(arr, row, col + newSize, newSize)
        // 왼쪽 아래
        compress(arr, row + newSize, col, newSize)
        // 오른쪽 아래
        compress(arr, row + newSize, col + newSize, newSize)
    }
}
