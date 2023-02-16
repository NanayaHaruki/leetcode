


fun main() {
   val i = kotlin.math.log2(4096.0)
   println(1920*1080/4*5)
}

class Solution1 {
    fun numberOfPairs(nums: IntArray): IntArray {
        // 移除相同数字，返回数对树木和剩下的数的个数
        val cnts = IntArray(101) { 0 }
        for(i in nums){
            cnts[i]++
        }
        var a = 0
        var b = 0
        for(i in 0..100){
            if(cnts[i]%2==0){
                a+=cnts[i]/2
            }else{
                a+=cnts[i]/2
                b+=1
            }
        }
        return intArrayOf(a,b)
    }
}

    