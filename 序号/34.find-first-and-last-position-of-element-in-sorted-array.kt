class Solution {
    /** 找一个数出现左右边界 */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1,-1)
        return intArrayOf(findLeft(nums,target),findRight(nums, target))
    }

    fun findLeft(nums: IntArray,target:Int):Int{
        var l = 0
        var r = nums.lastIndex
        while(l<=r){
            val mid = l+(r-l)/2
            if (nums[mid]==target){
                r=mid-1
            }else if(nums[mid]>target){
                r=mid-1
            }else if (nums[mid] < target) {
                l=mid+1
            }
        }
        if (l >= nums.size || nums[l] != target) { // 越界了 或  l从初始化就没动过，所以得判断下==target
            return -1
        }
        return l
    }

    fun findRight(nums: IntArray,target:Int):Int{
        var l= 0
        var r = nums.lastIndex
        while(l<=r){
            val mid = l+(r-l)/2
            if (nums[mid]  == target){
                l=mid+1
            }else if (nums[mid] > target) {
                r=mid-1
            }else if (nums[mid] < target) {
                l=mid+1
            }
        }
        if (r < 0 || nums[r] != target) {
            return -1
        }
        return r
    }
}