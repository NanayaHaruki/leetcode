class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if(timeSeries.size==1) return duration
        var ans = 0
        for (i in 1 until timeSeries.size){
            // 攻击间隔大于DOT每跳，自增每跳时间；小于每跳，毒持续时间就是当前攻击间隔
            ans+= minOf(timeSeries[i]-timeSeries[i-1],duration)
        }
        ans+=duration // 最后一次攻击的毒持续时间
        return ans
    }
}