class Solution {
    private var ans = 0
    private lateinit var apples: IntArray
    private lateinit var days: IntArray
    private val sortedMap = sortedMapOf<Int, Int>()
    fun eatenApples(_apples: IntArray, _days: IntArray): Int {
        // 贪心 每天只能吃一个  每天都吃快到期的
        // 遍历2个数组，按到期时间排序
        // 先弹出过期的，再优先吃保质期短的，吃完结束
        apples = _apples
        days = _days
        val n = days.size

        for (i in 0 until n) {
            eat(i)
        }
        var i = n
        while (sortedMap.isNotEmpty()) {
            eat(i)
            i++
        }
        return ans
    }

    private fun eat(i: Int) {
        sortedMap.remove(i)
        if (i < days.size && apples[i] > 0) {
            sortedMap[i + days[i]] = apples[i] // 设置过期时间
        }
        if (sortedMap.isNotEmpty()) {
            val firstKey = sortedMap.firstKey()
            val nearApples = sortedMap[firstKey] ?: return // 最近的时间还有多少个苹果
            if (nearApples == 1) {
                sortedMap.remove(firstKey)
                ans++
            } else if (nearApples > 1) {
                sortedMap[firstKey] = nearApples - 1
                ans++
            }
        }
    }
}