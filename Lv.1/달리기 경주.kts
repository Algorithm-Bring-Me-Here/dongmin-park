class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // 선수 이름을 키로, 현재 순위를 값으로 하는 해시맵
        val rankMap = players.mapIndexed { index, name -> name to index }.toMap().toMutableMap()
        // 순위를 키로, 선수 이름을 값으로 하는 해시맵
        val playerMap = players.mapIndexed { index, name -> index to name }.toMap().toMutableMap()
        
        for (calledPlayer in callings) {
            val currentRank = rankMap[calledPlayer]!!
            val prevRank = currentRank - 1
            val prevPlayer = playerMap[prevRank]!!

            // 순위 교체
            rankMap[calledPlayer] = prevRank
            rankMap[prevPlayer] = currentRank
            
            playerMap[prevRank] = calledPlayer
            playerMap[currentRank] = prevPlayer
        }
        
        return playerMap.entries.sortedBy { it.key }.map { it.value }.toTypedArray()
    }
}
