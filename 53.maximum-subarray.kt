class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        var max = Int.MIN_VALUE
    	var sum = 0
        for(i in nums){
        	sum+=i
            // 比较最大值和新的累加值
        	max = Math.max(max,sum)
        	// 累加值为负，则归0，让下次循环的sum取新值；
        	// 累计值为正，则会一直与新值想加并且与max进行比对。
        	sum = Math.max(sum,0)
        }
        return max
    }

    /** 前缀和
    fun maxSubArray(nums: IntArray): Int {
    // 找子数组中的最大和
    // 算出前缀和，pre[x]-pre[y]  (y,x)区间就是答案
    // 遍历前缀和数组，更新最小值，用当前值去减，差最大为答案
    val n = nums.size
    val pre = IntArray(n+1)
    for (i in nums.indices){
    pre[i+1]=pre[i]+nums[i]
    }
    var min = 0
    var ans = Int.MIN_VALUE
    for (i in 1..n){
    ans = max(pre[i]-min,ans)
    min = min(pre[i],min)
    }
    return ans
    }
     */

    /** 动规 */
    fun maxSubArray(nums: IntArray): Int {
        var pre = 0
        var ans = nums[0]
        for (num in nums) {
            pre = max(pre + num, num)
            ans = max(pre, ans)
        }
        return ans
    }
}
