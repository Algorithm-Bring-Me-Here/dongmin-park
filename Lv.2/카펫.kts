class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val total = brown + yellow
        
        for (height in 3..total) {
            if (total % height == 0) {
                val width = total / height
                
                // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길어야 함
                if (width < height) continue
                
                // 노란색 영역의 크기 계산
                val yellowArea = (width - 2) * (height - 2)
                
                if (yellowArea == yellow) {
                    return intArrayOf(width, height)
                }
            }
        }

        return intArrayOf()
    }
}
