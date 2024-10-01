class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val f = Array(days.size){IntArray(31){-1}} // f[i][j] 第days[i]天的旅行用的是第j种通行证，花了最少多少钱及通行证还剩几天
        f[0][1]=costs[0]
        f[0][7]=costs[1]
        f[0][30]=costs[2]
        for(i in 1 until days.size){
            val preDay = days[i-1]
            val curDay = days[i]
            var minCost = Int.MAX_VALUE
            for(j in 1..30){
                if(f[i-1][j]>0){
                    if(preDay+j>curDay) { // 1+3 =4 >3 ,够用，继续用，更新通行证时间
                        val diffDay = curDay-preDay
                        if (f[i][j-diffDay]<0) f[i][j-diffDay]=f[i-1][j]
                        else if(f[i-1][j]<f[i][j-diffDay]) f[i][j-diffDay]=f[i-1][j]
                    }
                    else
                        if(f[i-1][j]<minCost) minCost=f[i-1][j]
                }
            }
            if(f[i][1]==-1) f[i][1]=minCost+costs[0]
            else f[i][1]=min(f[i][1],minCost+costs[0])

            if(f[i][7]==-1) f[i][7]=minCost+costs[1]
            else f[i][7]=min(f[i][7],minCost+costs[1])

            if(f[i][30]==-1)f[i][30]=minCost+costs[2]
            else f[i][30]=min(f[i][30],minCost+costs[2])
        }
        return f.last().filter { it>0 }.min()
    }
}