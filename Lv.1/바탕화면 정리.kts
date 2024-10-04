class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var lux = 51
        var luy = 51
        var rdx = -1
        var rdy = -1
        
        val size = wallpaper[0].length
        
        for(week in 0 until wallpaper.size) { 
            for(position in 0 until size) {
                if(wallpaper[week][position] == '#') {
                  // lux, luy는 좌측 상단이어야 하기 때문에 나온 애들 중 가장 낮은 값이 됨
                  // rdx, rdy는 우측 하단이어야 하기 때문에 나온 애들 중 가장 낮은 값이 됨.
                  // 이때, rdx와 rdy에 해당하는 값까지 포함이 되어야 하기 때문에 +1을 해줌
                    if(week <= lux) lux = week
                    if(week >= rdx) rdx = week + 1
                    if(position <= luy) luy = position
                    if(position >= rdy) rdy = position + 1
                }
            }            
        }

        return intArrayOf(lux, luy, rdx, rdy)
    }
}
