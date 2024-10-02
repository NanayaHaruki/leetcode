class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        val busCnt = dist.size
        if(hour<=busCnt-1) return -1 // 等于就要求最后辆车速度无限快
        var l=0
        var r = Int.MAX_VALUE
        fun check(v:Int):Boolean{
            var t = 0
            for(i in 0 until dist.size-1){
                val d = dist[i]
                if(d%v==0) t+=d/v
                else t+=d/v+1
            }
            return t+dist.last().toDouble()/v<=hour
        }
        while(l+1<r){
            val m = l+(r-l)/2
            if(check(m)){
                r=m
            }else{
                l=m
            }
        }
        return r
    }
}