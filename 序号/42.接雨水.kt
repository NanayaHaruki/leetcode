import kotlin.math.*

class Solution {
    fun trap(height: IntArray): Int {
        // 如果i比i-2高，那么重新继续，比他低或相等时统计实时雨量
        // 对于每个位置i，他能接的水 为他左边最高的和右边最高的小值减去自身的高度
        val n = height.size
        val left = IntArray(n).apply { this[0]=height[0] }
        val right = IntArray(n).apply { this[n-1]=height[n-1]}
        for (i in 1 until n){
            left[i]=max(left[i-1],height[i]) // 每个位置都是自己与左边的最大值，所以只需要用前值与当前项比即可
            right[n-1-i]=max(right[n-i],height[n-1-i])
        }
        var ans = 0
        for (i in 0 until n){
            // 计算每个点可以累积多少雨，为每个点左右大值中的较小者-自身的高度
            val m = min(left[i],right[i])
            val diff = m-height[i]
            // 两边最高的小值比当前高才能积累雨水
            if (diff>0) ans+= diff
        }
        return ans
    }
}