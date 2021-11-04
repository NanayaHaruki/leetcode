class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        var (up,down) = 1 to 1
        for (i in 1 until nums.size){
            if (nums[i]>nums[i-1]) {
                // 比前一个大
                up = down+1
            }else if (nums[i] < nums[i - 1]) {
                down=up+1
            }
        }
        return if (nums.isEmpty()) 0 else maxOf(up,down)
    }
}