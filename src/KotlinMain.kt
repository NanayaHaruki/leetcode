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
        val a = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
        rotate(a)
        for (ints in a) {
            for (int in ints) {
                print(int)
            }
            println()
        }

    }
}