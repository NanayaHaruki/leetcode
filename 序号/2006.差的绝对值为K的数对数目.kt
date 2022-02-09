import kotlin.math.abs
class Solution {
	fun countKDifference(nums: IntArray, k: Int): Int {
		var ans = 0
		for (i in 0 until nums.size - 1) {
			for (j in i + 1 until nums.size) if (abs(nums[i] - nums[j]) == k) ans++
		}
		return ans
	}
}