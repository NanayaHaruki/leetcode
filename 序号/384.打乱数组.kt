import kotlin.random.Random

class Solution(nums: IntArray) {
    private val oriArr = nums
    private val copyArr = oriArr.copyOf()

    fun reset(): IntArray {
        return oriArr
    }

    fun shuffle(): IntArray {
        for (i in copyArr.indices){
            val j = Random.nextInt(i,copyArr.size)
            val tmp = copyArr[j]
            copyArr[j]=copyArr[i]
            copyArr[i]=tmp
        }
        return copyArr
    }
}