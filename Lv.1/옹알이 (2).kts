package LV.`1`

fun main() {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val words = listOf("aya", "ye", "woo", "ma")

        babbling.forEach {
            var sentence = it
            var beforeWord = ""
            var canSlice = false

            while(true) {
                for (word in words) {
                    if (sentence.startsWith(word) && beforeWord != word) {
                        beforeWord = word
                        sentence = sentence.slice(word.length .. sentence.length-1)
                        canSlice = false

                        break
                    }
                }

                if (sentence.isEmpty()) {
                    answer++
                    break
                }
                if (canSlice) break

                canSlice = true
            }
        }

        return answer
    }

    println(solution(arrayOf("aya", "yee", "u", "maa")))
}
