class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val h = park.size  // 공원의 세로 길이
        val w = park[0].length  // 공원의 가로 길이
        
        // 방향에 따른 좌표 이동을 위한 맵
        val directionMap = mapOf(
            "N" to Pair(-1, 0),  // 북쪽: 세로로 -1
            "S" to Pair(1, 0),   // 남쪽: 세로로 +1
            "W" to Pair(0, -1),  // 서쪽: 가로로 -1
            "E" to Pair(0, 1)    // 동쪽: 가로로 +1
        )
        
        // 시작점 찾기
        var startX = 0
        var startY = 0
        for (i in park.indices) {
            for (j in park[i].indices) {
                if (park[i][j] == 'S') {
                    startX = i
                    startY = j
                    break
                }
            }
        }

        var currentX = startX
        var currentY = startY

        for (route in routes) {
            val (direction, distance) = route.split(" ")
            val moveDistance = distance.toInt()
            val (dx, dy) = directionMap[direction]!!

            // 이동 중 장애물 및 범위 체크
            var canMove = true
            var newX = currentX
            var newY = currentY

            for (step in 1..moveDistance) {
                val nextX = currentX + dx * step
                val nextY = currentY + dy * step

                // 공원 범위를 벗어나는지 확인
                if (nextX !in 0 until h || nextY !in 0 until w) {
                    canMove = false
                    break
                }

                // 장애물이 있는지 확인
                if (park[nextX][nextY] == 'X') {
                    canMove = false
                    break
                }

                // 이동이 가능할 경우 좌표를 업데이트
                newX = nextX
                newY = nextY
            }

            // 조건을 만족하면 위치 갱신
            if (canMove) {
                currentX = newX
                currentY = newY
            }
        }

        return intArrayOf(currentX, currentY)
    }
}

