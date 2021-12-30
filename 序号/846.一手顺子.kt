fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    // 能否将牌 组成顺子  每组顺子长度为groupsize
    // 遍历hand，得知什么牌有多少张，然后依次打出这些顺子，能打完就为true
    if (hand.size % groupSize != 0) return false
    hand.sort()
    val dict = mutableMapOf<Int, Int>()
    for (x in hand) dict[x] = dict.getOrDefault(x, 0) + 1
    for (x in hand) {
        dict[x] ?: continue
        for (i in 0 until groupSize) {
            val num = x + i
            val cnt = dict[num]
            if (cnt == null) {
                return false
            } else {
                if (cnt == 1) {
                    dict.remove(num)
                } else {
                    dict[num] = cnt - 1
                }
            }
        }
    }
    return true
}