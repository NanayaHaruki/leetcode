const val SUM = 0
const val SUM_MAX = 1
const val ARR1_INDEX = 2
const val ARR2_INDEX = 3
const val ARR3_INDEX = 4

class Solution {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        // 三个数组从起始点开始往右边挪，分别记录历史极值和极值索引
        val arr1 = IntArray(3) // 和，最大和，最大和的索引
        val arr2 = IntArray(4) // 和，前2个数组的最大和，最大和时候数组1的索引，最大和的时候数组2的索引
        val arr3 = IntArray(5) // 和，前3个数组的最大和,数组1的索引，数组2的索引，数组3的索引
        // 3个数组起始点为0,k，2k，最多到size-3*k
        for (i in 2*k until nums.size){
            arr1[SUM]+=nums[i-2*k]
            arr2[SUM]+=nums[i-k]
            arr3[SUM]+=nums[i]
            // 填入长度k之后，就要开始对比最大值了
            if (i>=3*k-1){
                // 更新最左边的第一个数组
                if (arr1[SUM] > arr1[SUM_MAX]) {
                    arr1[SUM_MAX]=arr1[SUM]
                    arr1[ARR1_INDEX]=i-3*k+1
                }
                // 更新第2个数组
                if (arr2[SUM] + arr1[SUM_MAX] > arr2[SUM_MAX]) {
                    arr2[SUM_MAX]=arr2[SUM]+arr1[SUM_MAX]
                    arr2[ARR1_INDEX]=arr1[ARR1_INDEX]
                    arr2[ARR2_INDEX]=i-2*k+1
                }
                // 更新第3个数组
                if (arr3[SUM] + arr2[SUM_MAX] > arr3[SUM_MAX]) {
                    arr3[SUM_MAX]=arr3[SUM] + arr2[SUM_MAX]
                    arr3[ARR1_INDEX]=arr2[ARR1_INDEX]
                    arr3[ARR2_INDEX]=arr2[ARR2_INDEX]
                    arr3[ARR3_INDEX]=i-k+1
                }
                arr1[SUM]-=nums[i-3*k+1]
                arr2[SUM]-=nums[i-2*k+1]
                arr3[SUM]-=nums[i-k+1]

            }
        }
        return intArrayOf(arr3[ARR1_INDEX], arr3[ARR2_INDEX], arr3[ARR3_INDEX])
    }
}