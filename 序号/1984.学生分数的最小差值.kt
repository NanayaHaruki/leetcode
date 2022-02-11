import java.util.*

class Solution {
	fun minimumDifference(nums: IntArray, k: Int): Int {
		// 取出k，让最大最小值的差最小
		// 滑动窗口，窗口长度为k，寻找差值的极小值即可
		nums.sort()
		var ans = Int.MAX_VALUE
		for (i in k-1 until nums.size){
			ans = minOf(ans,nums[i]-nums[i-k+1])
		}
		return ans
	}
}