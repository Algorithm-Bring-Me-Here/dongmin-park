class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        val resultMap: HashMap<String, Int> = hashMapOf()

        for ((index, value) in name.withIndex()) {
            resultMap[value] = yearning[index]
        }

        photo.forEach { pic ->
            var sum = 0
            pic.forEach { name ->
                sum += resultMap[name]?:0
            }

            answer = answer.plus(sum)
        }


        return answer
    }
}

/*
이름과 점수를 연결시켜 hashMap으로 만들었습니다.
name과 yearning을 zip 함수를 활용하여 하나로 묶어줬습니다.
key는 이름으로, value는 추억점수로 기록하였습니다.

photo의 길이만큼 forEach를 동작시키고, 내부에 있는 배열또한 forEach를 동작시킵니다.
photo와 관련된 for문에서 var sum = 0을 선언하여 이후 추억점수의 합을 더하고, 배열에 더해줍니다.
*/
