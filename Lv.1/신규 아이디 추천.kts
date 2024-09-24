class Solution {
    fun solution(new_id: String): String {
        var result = new_id
        
        // 1단계
        result = result.toLowerCase()
        
        // 2단계
        result = validateString(result)
        
        // 3단계
        result = mergePoint(result)
        
        // 4단계
        result = deleteStartEndPoint(result)
        
        // 5단계
        result = if(result.isEmpty()) "a" else result
        
        // 6단계
        result = if(result.length >= 16) result.slice(0..14) else result
        
        // 7단계
        result = repeatLastChar(result)
        
        // 4단계
        result = deleteStartEndPoint(result)
        
        return result
    }

    // 정해진 범위 안에 있다면 값을 취하고, 아니면 버렸습니다.
    // 끝나고 생각해보니 filter를 쓸껄 그랬네요
    fun validateString(text: String): String {
        var result = ""
        
        for(i in text) {
            when {
                i in 'a' .. 'z' -> result += i
                i in '0' .. '9' -> result += i
                i == '-' -> result += i
                i == '_' -> result += i
                i == '.' -> result += i
                else -> {}
            }
        }
        
        return result
    }

    // .이 반복된다면 즉, 자신이 .이고 뒤에도 .이라면 더하지 않았습니다.
    // 이렇게 되면 맨 뒤에있는 .만 추가됩니다.
    fun mergePoint(text: String): String {
        var result = ""
        
        for(i in 0 until text.length - 1) {
            if(text[i] == '.' && text[i + 1] == '.'){
                
            } else {
                result += text[i]
            }
        }
        
        return result + text.last()
    }

    // 일단 앞뒤를 자르고, .이 아닐경우 다시 이어붙였습니다.
    // 성능상으로 안좋을거 같긴 한데 일단 구현에 초점을 뒀어요
    fun deleteStartEndPoint(text: String): String {
        if(text.isEmpty()) return ""
        
        var result = text.slice(1 .. text.length - 2)
        
        if(text.first() != '.') {
            result = text.first() + result
        }
        
        if(text.last() != '.') {
            result = result + text.last()
        }
        
        return result
    }

    // 맨 뒷 글자를 글자수가 3 미만이라면 반복했습니다.
    fun repeatLastChar(text: String): String {
        var result = text
        
        while (result.length < 3) {
            result += text.last()
        }
        
        return result
    }
}
