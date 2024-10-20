class Solution {
    fun smallestRangeI(nums: IntArray, k: Int): Int {
        val a = nums.min()
        val b = nums.max()
        return max(0,b-a-2*k)
    }
}