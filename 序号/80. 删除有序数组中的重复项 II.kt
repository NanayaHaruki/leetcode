class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var l = 0
        var r = 0
        var t = nums[0]
        val n = nums.size
        while(l<n){
            val old_r = r
           while(r<n && nums[r]==t) ++r
          
            if(r-old_r>=2) {
                nums[l]=t
                nums[l+1]=t
                l+=2
            }else{
                nums[l]=t
                l+=1
            }
            if(r==n) break
            t=nums[r]
           
        }
        return l
    }
}