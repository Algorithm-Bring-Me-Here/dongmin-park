class Solution {    
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val newOpStart = getSecTime(op_start)
        val newOpEnd = getSecTime(op_end)
        val newVideoLen = getSecTime(video_len)
        
        var newPos = getSecTime(pos)
        
        newPos = moveEndIfInOp(newOpStart, newOpEnd, newPos)
        
        for(command in commands) {
            if(command == "next") {
                newPos += 10
            } else if(command == "prev") {
                newPos -= 10
            }
            
            newPos = moveIfNotValid(newPos, newVideoLen)
            newPos = moveEndIfInOp(newOpStart, newOpEnd, newPos)
        }
        
        val min = newPos / 60
        val sec = newPos % 60 % 60
        
        
        return setZeroPrefix(min) + ":" + setZeroPrefix(sec)
    }
    
    fun getSecTime(time: String): Int = time.slice(0 .. 1).toInt() * 60 + time.slice(3..4).toInt()
    fun moveEndIfInOp(newOpStart: Int, newOpEnd: Int, pos: Int): Int = if(pos in newOpStart .. newOpEnd) newOpEnd else pos
    fun moveIfNotValid(pos: Int, videoLen: Int): Int = if(pos <= 0) 0 else if(pos >= videoLen) videoLen else pos
    fun setZeroPrefix(time: Int): String = if(time < 10) "0${time}" else time.toString()
}

/*
getSecTime : String에서 시간을 추출. 추출하는 과정에서 연산의 편의성을 위해 분도 초단위로 합쳐서 구현
moveEndIfInOp : 만약 오프닝 시간 내부라면 오프닝의 종료시간으로 이동
moveIfNotValid : 0초 이하 혹은 비디오의 최대 길이 이상이라면 최댓값으로 이동
setZeroPrefix : 한자릿수라면 앞에 0을 붙임
*/
