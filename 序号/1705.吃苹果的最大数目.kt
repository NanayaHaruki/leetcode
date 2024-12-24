/** 24/12/24 */
class Solution {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        // 先吃快烂的
        val pq = PriorityQueue<IntArray>{a,b->a[0]-b[0]}
        val n = apples.size
        var ans = 0
        var d = 0
        while(d<n || pq.isNotEmpty()){
            if(d<n && apples[d]>0){
                pq.offer(intArrayOf(d+days[d],apples[d]))
            }
            while(pq.isNotEmpty()) {
                val arr = pq.peek()
                if(arr[0]<=d) {
                    pq.poll()
                }else{
                    if (arr[1]==1){
                        pq.poll()
                    }else{
                        arr[1]-=1
                    }
                    ++ans
                    break
                }
            }
            ++d
        }
        return ans
    }
}

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