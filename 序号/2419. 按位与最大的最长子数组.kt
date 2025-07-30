class Solution {
    fun longestSubarray(nums: IntArray): Int {
        // 与只能让值不变或变小，子数组的与最大值，就是子数组只存在整个数组最大值
        val mx = nums.max()
        var len = 0
        var mxLen = 0
        for(x in nums){
            if(x==mx){
                len++
                if(len>mxLen) mxLen=len
            }else{
                len=0
            }
        }
        return mxLen
    }
}