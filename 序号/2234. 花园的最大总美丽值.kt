class Solution {
    fun maximumBeauty(flowers: IntArray, newFlowers: Long, target: Int, full: Int, partial: Int): Long {
        // flowers[i]达到target，算full分。没达到，按所有没达到的最小值，每个算partial分
        // 考虑填满至 x 个花园，总分就是 x*full。
        // 剩下的分到没满的上去，因为按最小花园计算，所以平均分可以让最小值最大
        // 得考虑没满就是没满，不可以计算剩下的将不满的花园填满的情况
        flowers.sort()
        val n = flowers.size

        val ps = LongArray(n+1) // ps[i]表示前i个花园 [0,i-1]的总数
        for (i in 1..n){
            flowers[i-1]=min(flowers[i -1],target) // 后面要计算满的花园总花数，这样方面统计
            ps[i]=ps[i-1]+flowers[i- 1]
        }
        var rightLimit = n
        while (rightLimit-1>=0 && flowers[rightLimit-1]>=target) {
            --rightLimit
        }
        if (rightLimit==0) return 1L*full*n
        // [i+1,n) 是已经满的，n-1-i个满的花园分数不能动，因为只能种花，不能拔掉，即使partial>full。
        // 考虑newFlowers种下去可以让多少个不满成为满的
        var l = -1
        var r = n
        while (l+1<r){
            val m = (l+r)/2
            val cur = ps.last()-ps[m]
            if (cur+newFlowers>=1L*(n-m)*target){ // 能将 [m,n)填满
                r=m // 缩短右边界，尝试填更多的
            }else{
                l=m
            }
        }
        val leftLimit = r
        var score = 0L
        for (j in leftLimit .. rightLimit){ // r 为能填满的最左边的位置  i为只填1个
            if(j==0){ // 可以种满，2种策略，留一个不种满，种target-1
                score = max(score,max(1L*n*full,1L*(n-1)*full+1L*(target-1)*partial))
                continue
            }
            val remain = newFlowers -  (1L*(n-j)*target -( ps.last()- ps[j]))
            l=flowers[0]
            r=target
            while(l+1<r){
                val m = (l+r)/2 // 找可以将未满的最小值提高到几
                var (ll,rr) = -1 to j
                while (ll+1<rr){
                    val mm = (ll+rr)/2
                    if (flowers[mm]<m){
                        ll=mm
                    }else{
                        rr=mm
                    }
                }
                if (ps[rr]+remain >= 1L*m*rr){
                    l=m
                }else{
                    r=m
                }
            }
            val newScore = 1L*l*partial+1L*(n-j)*full
            if (newScore>score){
                score=newScore
            }
        }
        return score
    }
}