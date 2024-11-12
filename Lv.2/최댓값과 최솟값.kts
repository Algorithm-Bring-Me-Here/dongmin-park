class Solution {
    fun solution(s: String): String = s.split(" ").map{
        it.toInt()
    }.let{
        "${it.minOf{it}} ${it.maxOf{it}}"
    }    
}
