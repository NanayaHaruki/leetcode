/**
 *给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。请注意，返回的下标值（index1 和 index2）不是从零开始的。
 *你可以假设每个输入都只有一个解决方案，而且你不会重复使用相同的元素。
 *输入：数组 = {2, 7, 11, 15}, 目标数 = 9
 *输出：index1 = 1, index2 = 2
 */
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        if (numbers.isEmpty()) return intArrayOf()
        out@ for (i in numbers.indices) {
            inner@ for (j in 1..numbers.size - 1 - i) {
                val sum = numbers[i] + numbers[i + j]
                when {
                    sum > target -> continue@out
                    sum < target -> continue@inner
                    sum == target -> {
                        result[0] = i + 1
                        result[1] = i + j + 1
                        break@out
                    }
                }
            }

        }
        return result
    }
}
