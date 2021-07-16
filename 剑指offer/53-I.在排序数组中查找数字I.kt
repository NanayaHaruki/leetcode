class Solution {
    /** 找一个数出现次数 */
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        // 2次二分，一次找左边界 一次找右边界
        val l = findLeft(nums,target)
        val r = findRight(nums,target)
        if (l==-1) return 0
        return r-l+1
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