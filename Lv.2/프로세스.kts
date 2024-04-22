package LV.`2`

import java.util.*

fun main() {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val queue: Queue<Int> = LinkedList()

        for (i in priorities.indices) {
            queue.offer(i)
        }

        while (true) {
            val a = queue.poll()

            if (priorities[a] != priorities.maxOrNull()) {
                queue.offer(a)
            } else {
                answer++

                if (a == location) {
                    break
                }

                priorities[a] = 0
            }
        }

        return answer
    }

    println(solution(intArrayOf(2, 1, 2, 1, 2, 1, 2, 1, 2),1))
}
