package easy.array

/**
 * 移动零
 */

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。

fun moveZeroes(nums: IntArray): Unit {
    // 相当于冒泡呗
    for (i in 0 until nums.lastIndex) {
        fun bubble() {
            for (j in i until nums.lastIndex) {
                nums[j] = nums[j + 1]
            }
            nums[nums.lastIndex] = 0
        }

        var zeroCount = 0
        while (nums[i] == 0 && i < nums.size - zeroCount) {
            zeroCount++
            bubble()
        }
    }
}