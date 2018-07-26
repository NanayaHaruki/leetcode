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
}
