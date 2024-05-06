class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val row = board.size
        val answer = mutableListOf<Int>()
        var count = 0

        for (m in moves) {
            for (i in 0 until row) {
                if (board[i][m - 1] != 0) {
                    answer.add(board[i][m - 1])
                    board[i][m - 1] = 0
                    break
                }
            }

            if (answer.size > 1 && answer[answer.size - 2] == answer[answer.size - 1]) {
                answer.removeAt(answer.size - 1)
                answer.removeAt(answer.size - 1)
                count += 2
            }
        }
        return count
    }
}
