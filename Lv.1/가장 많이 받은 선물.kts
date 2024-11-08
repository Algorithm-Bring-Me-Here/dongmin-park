class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer = 0

        val whoGiveGift = mutableMapOf<String, MutableList<String>>()
        val presentReceive = mutableMapOf<String, Int>()
        val presentGive = mutableMapOf<String, Int>()
        val presentPercent = mutableMapOf<String, Int>()
        val finalReceivePresent = mutableMapOf<String, Int>()

        gifts.forEach { gift ->
            val (giver, receiver) = gift.split(" ")
            whoGiveGift.computeIfAbsent(giver) { mutableListOf() }.add(receiver)
            presentGive[giver] = presentGive.getOrDefault(giver, 0) + 1
        }

        friends.forEach { friend ->
            val receivedGiftCount = whoGiveGift.values.flatten().count { it == friend }
            presentReceive[friend] = receivedGiftCount
            presentPercent[friend] = (presentGive[friend] ?: 0) - receivedGiftCount
            finalReceivePresent[friend] = 0
        }

        friends.forEachIndexed { i, me ->
            var maxValue = Int.MIN_VALUE
            friends.forEachIndexed { j, other ->
                if (i != j) {
                    val giftsToOther = whoGiveGift[me]?.count { it == other } ?: 0
                    val giftsToMe = whoGiveGift[other]?.count { it == me } ?: 0

                    when {
                        giftsToOther > giftsToMe -> finalReceivePresent[me] = finalReceivePresent.getOrDefault(me, 0) + 1
                        giftsToOther == giftsToMe && (presentPercent[me] ?: 0) > (presentPercent[other] ?: 0) -> {
                            finalReceivePresent[me] = finalReceivePresent.getOrDefault(me, 0) + 1
                        }
                    }
                }
            }
            maxValue = maxOf(maxValue, finalReceivePresent[me] ?: 0)
            answer = maxOf(answer, maxValue)
        }

        return answer
    }
}
