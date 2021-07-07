class Solution {
    fun countPairs(deliciousness: IntArray): Int {
        // 遍历一遍 找到最大值， 2数之和固定下来，用例最大2^20，不用考虑溢出，找出小于极值的2的幂
        // 继续遍历，遍历到每个数，找一下可以组成2的幂的数字在前面遍历时出现的次数。  次数用map记录
        var max = deliciousness.maxOrNull()?:0
        max*=2
        val twoPowList = mutableListOf<Int>()
        var i = 1
        while (i <= max) {
            twoPowList.add(i)
            i*=2
        }
        var ans = 0
        val mod = 1000000007
        val mp = mutableMapOf<Int,Int>()
        for (j in deliciousness) {
            for (k in twoPowList) {
                val m = k-j //找可以和j组成2的幂的数
                val cnt = mp.getOrDefault(m,0) //m+j 为2的幂，以前出现次数为cnt
                ans = (ans+ cnt) % mod// 加到结果上
            }
            mp[j] = mp.getOrDefault(j,0)+1 // 提升该数出现次数
        }
        return ans
    }
}