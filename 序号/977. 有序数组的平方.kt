class Solution {
    fun findZero(nums:IntArray):Int{
        var l =  -1
        var r = nums.size
        while(l+1<r){
            val mid = (l+r)/2
            if(nums[mid]==0) return mid
            if(nums[mid]>0){
                r=mid
            }else{
                l=mid
            }
        }
        return r
    }
    fun sortedSquares(nums: IntArray): IntArray {
        // 2分找到>=0的位置，双指针依次移动找绝对值小的，计算平方
        var pr = findZero(nums)
        var pl = pr-1
        val n = nums.size
        val ans = IntArray(nums.size)
        for(i in nums.indices){
            if(pl<0){
                ans[i]=nums[pr]*nums[pr++]
            }else if(pr==n){
                ans[i]=nums[pl]*nums[pl--]
            }else{
                if(abs(nums[pl])<=abs(nums[pr])){
                    ans[i]=nums[pl]*nums[pl--]
                }else{
                    ans[i]=nums[pr]*nums[pr++]
                }
            }
        }
        return ans
    }
}