class Solution {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        //building的参数为left right height
        // 遍历数组，将buidings的left和right 拆开 重新根据横坐标排序
        // 再次遍历，左端点入队列，右端点移出队列  ，利用pq 每次获取当前最高建筑，最高高度发生变化时，加入答案
        val list = mutableListOf<IntArray>()
        for (building in buildings) {
            list.add(intArrayOf(building[0], -building[2])) // 左边界和高度，
            list.add(intArrayOf(building[1], building[2])) // 右边界和高度
        }
        list.sortWith(object:Comparator<IntArray>{
            override fun compare(arr1: IntArray, arr2: IntArray): Int {
                return if (arr1[0] == arr2[0]) {
                    arr1[1] - arr2[1]
                } else {
                    arr1[0] - arr2[0]
                }
            }
        })

        val ans = mutableListOf<List<Int>>()
        val pq = PriorityQueue<Int>{i1,i2-> i2-i1} // 用于存储高度
        var maxHeight = 0
        pq.add(0)
        for ((x, y) in list) {
            if (y < 0) pq.add(-y) // 左边界移入，右边界移出
            else pq.remove(y)

            // 比对最高高度有无出现变化
            val curHeight = pq.peek()
            if (curHeight != maxHeight) {
                ans.add(listOf(x, curHeight))
                maxHeight = curHeight
            }
        }
        return ans
    }
}