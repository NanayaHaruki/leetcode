import easy.array.intersect
import easy.array.moveZeroes
import easy.array.plusOne
import easy.array.rotate

/**
 *@Author: taoye
 *@Description:
 *@Date: 14:50 2019/2/18
 */
object KotlinMain{
    @JvmStatic
    fun main(args: Array<String>) {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val res = IntArray(2)
            for (i in 0 until nums.lastIndex) {
                if (i < target) {
                    for (j in i + 1..nums.lastIndex) {
                        if (nums[i] + nums[j] == target) {
                            res[0] = nums[i]
                            res[1] = nums[j]
                        }
                    }
                }
            }
            return res
        }
        println(twoSum(intArrayOf(2,2,5,2,6,8,7),9).toList())


    }
}