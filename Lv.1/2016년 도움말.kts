class Solution {
    fun solution(a: Int, b: Int): String {
        val monthList = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var days = 0
        
        if(a > 1) {
            for(i in 0 until a - 1) {
                days += monthList[i]
            }
        }
        days += b
        
        return when(days % 7) {
            0 -> "THU"
            1 -> "FRI"
            2 -> "SAT"
            3 -> "SUN"
            4 -> "MON"
            5 -> "TUE"
            else -> "WED"
        }
    }
}
/*
윤년 -> 2월 29일

1월 : 31
2월 : 29
3월 : 31
4월 : 30
5월 : 31
6월 : 30
7월 : 31
8월 : 31
9월 : 30
10월 : 31
11월 : 30
12월 : 31

a월 -1 만큼 월에 따른 일을 더함
그 후 일을 더함

숫자 % 7 -> 요일이 나옴
*/
