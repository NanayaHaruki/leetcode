class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size==1) return 0
        var l = 0
        var r = nums.lastIndex
        while(l<=r){
            val mid = l+(r-l)/2
            if (mid==nums.lastIndex || nums[mid] > nums[mid + 1]) {
                r=mid-1
            }else if (nums[mid] < nums[mid + 1]) {
                l=mid+1
            }
        }
        if (r==nums.lastIndex) return r
        else return r+1

    }
}