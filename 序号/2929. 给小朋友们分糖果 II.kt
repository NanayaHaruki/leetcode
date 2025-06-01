class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        // var ans = 0L
        // for(i in 0 .. min(n,limit)){
        //     val left = n-i // 一个人拿i，剩下的两个人分
        //     if(n-i > 2*limit) continue // 分不下，超了
        //     ans+= min(left,limit) - max(0,left-limit) + 1
        // }
        // return ans

        fun c(n:Int):Long{
            if(n<=1) return 0L
            return n.toLong()*(n-1)/2
        }
        return c(n+2) - 3*c(n-(limit+1)+2) + 3*c(n-2*(limit+1)+2) - c(n-3*(limit+1)+2)
    }
}