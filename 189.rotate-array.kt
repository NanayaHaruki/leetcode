/**
 *将包含 n 个元素的数组向右旋转 k 步。
 *例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 *尽可能找到更多的解决方案，这里最少有三种不同的方法解决这个问题。
 *要求空间复杂度为 O(1)
 */
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
    	// 注释中的例子，数组大小为7的话，走一步和走八步是一样的，所以要先模一下
    	var k = k % nums.size
    	// 1234 567 右移3步后变成567 1234
    	// 可以先将整个数组翻转 765 4321 
    	// 根据右移步数拆分成两部分 分别对左右两部分进行翻转即可得到567 1234
    	reverse(nums,0,nums.size - 1)
    	reverse(nums,0,k - 1) 
    	reverse(nums,k,nums.size - 1)
    }

    fun reverse(nums:IntArray,start:Int,end:Int) {
    	var start = start
    	var end = end
    	while(start < end) {
    		val temp = nums[start]
    		nums[start] = nums[end]
    		nums[end] = temp
    		start++
    		end--
    	}
    }
}
