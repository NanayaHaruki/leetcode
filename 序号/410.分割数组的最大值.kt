class Solution {
	fun splitArray(nums: IntArray, m: Int): Int {
		// 分成m个子数组 要求每个子数组和的最大值最小
		// 子数组最大值的最小值在nums的最大值（即每个数是一组）；子数组最大值的最大值是nums总和（即不分组）
		// 答案必然在这俩之间，用二分找，查看m个分组能否满足这个mid

		// 找最大值和总和
		var left = Int.MIN_VALUE
		var right = 0
		for (i in nums){
			left = maxOf(i,left)
			right+=i
		}
		while (left<right){
			val mid = left+(right-left)/2
			if (binarySearch(nums, mid, m)) {
				right=mid
			}else left=mid+1
		}
		return right
	}

	fun binarySearch(nums:IntArray,target:Int,m:Int):Boolean{
		var sum = 0
		var group = 0
		for (i in nums){
			sum+=i
			if (sum>target){
				sum=i
				group++
			}
		}
		return group+1 <= m
	}
}