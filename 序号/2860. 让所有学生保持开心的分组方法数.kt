class Solution {
    fun countWays(nums: List<Int>): Int {
        // 若选了第i个人，则要选至少nums[i]个人
        // 1,3,5,5   在3的位置，选了的话，只有2个人，而需要3个。所以3不能选
        val n = nums.size
        val sorted = nums.sorted()
        var ans=0
        for(i in 0..n){ // i 表示选几个人
            if((i>0 && sorted[i-1]>=i) || (i<n && sorted[i]<=i))
                continue
            ans++
        }
        return ans
    }
}