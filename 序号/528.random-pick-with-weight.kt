import kotlin.random.Random
class Solution(w: IntArray) {
    val preSum = IntArray(w.size+1)
    init {
        /*
        *   1 <= w.length <= 10000
            1 <= w[i] <= 10^5
            pickIndex 将被调用不超过 10000 次
        * */
        // 用集合将数字分成几段，比如w=[1,3],那么 0 一个数为一段   自增3次  1～3 为第2段，其实就是建一个前缀和
        // 然后在1+3开始随机，随到1以下，返回0, 随机到[1,3],返回2
        for (i in w.indices){
            preSum[i+1]=preSum[i]+w[i]
        }
    }
    fun pickIndex(): Int {
        val num = Random.nextInt(preSum.last())
        // 找i在preSum的哪个区间 ，w的长度在10^5以内，直接线性就行
        var ans = 0
        for (i in preSum.indices){
            if (num >= preSum[i]) {
                ans = i
            }else {
                break
            }
        }
        return ans
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */