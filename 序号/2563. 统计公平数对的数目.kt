class Solution {
    fun lower(nums: IntArray,t:Int,begin:Int,end:Int):Int{
        var l = begin-1
        var r = end
        while(l+1<r){
            val m = (l+r)/2
            if(nums[m]>t) r = m
            else l=m
        }
        return l
    }

    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        // 下标不影响，可以直接排序
        nums.sort()
        var ans = 0L
        nums.forEachIndexed { i, x ->
            ans+= lower(nums,upper-x,0,i) - lower(nums,lower-x-1,0,i)
        }
        return ans
    }
}