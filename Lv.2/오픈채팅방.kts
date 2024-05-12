class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val messages = mutableListOf<Pair<String, String>>()
        val userMap = hashMapOf<String, String>()

        record.forEach { log ->
            val userLog = log.split(" ")
            if(userLog[0] == "Enter"){
                messages += Pair(userLog[1], "님이 들어왔습니다.")
                userMap[userLog[1]] = userLog[2]
            }else if(userLog[0] == "Leave"){
                messages += Pair(userLog[1], "님이 나갔습니다.")
            }else {
                userMap[userLog[1]] = userLog[2]
            }
        }

        messages.forEach{
            answer += userMap[it.first] + it.second
        }

        return answer
    }
}
