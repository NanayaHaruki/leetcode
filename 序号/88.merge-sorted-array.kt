/**
 *Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *Note:
 *You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 *to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 
 *are m and n respectively.
 *
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    	// 注意，这里的m和n并不是nums1的大小。nums1只是预留了空位而已，
    	// 他的数据可能是空的，那么m就是0，而nums1的大小可能会很大，因为要包容nums2的数据

    	// num1的最大角标
        var maxIndex1 = m-1
        // num2的最大角标
        var maxIndex2 = n-1
        // 合并后的最大角标
        var index = m+n-1 
        while(maxIndex1>=0 && maxIndex2>=0) {
        	// 两个数组的最大值进行比较，确定合并后数组的最大值
        	// 比较完了之后，赋值。赋值
        	if(nums1[maxIndex1] > nums2[maxIndex2]) {
        		nums1[index--] = nums1[maxIndex1--]
        	}else {
        		nums1[index--] = nums2[maxIndex2--]
        	}
        }
        // 比对完了，某个数组的索引降到了0，对剩下的数组进行赋值
        while(maxIndex1 >= 0) {
        	nums1[index--] = nums1[maxIndex1--]
        }
        while(maxIndex2 >= 0) {
        	nums1[index--] = nums2[maxIndex2--]
        }
    }
}
