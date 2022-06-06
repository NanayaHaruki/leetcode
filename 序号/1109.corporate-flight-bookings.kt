class Solution() {
    /*
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        // bookings[0，1]为航班 [2]为座位  n为航班数量，返回每个航班预定座位
        // 这不是遍历一遍的事儿吗？注意下booking中的航班是从1开始的,暴力一波
        val ans = IntArray(n)
        for ((l,r,s) in bookings){
            for (i in l-1 .. r-1){
                ans[i]+=s
            }
        }
        return ans
    }
*/
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        // 数组不变，区间查询：前缀和 0jB43O
        // 区间修改，单点查询：差分
        // 单点修改，区间查询：树状数组
        // 区间修改，区间查询：线段树（其他问题也可以线段树解决，但效果不好，迫不得已才使用）

        // 当前问题是区间修改，单点查询，用差分，即前缀和的逆向
        val c = IntArray(n+1)
        for ((l,r,s) in bookings){ // l,r从1开始算的
            c[l-1]+=s
            c[r+1-1]-=s
        }
        // 答案就是用查分数组，还原前缀和
        val ans = IntArray(n)
        ans[0]=c[0]
        for (i in 1 until n) {
            ans[i]=ans[i-1]+c[i]
        }
        return ans
    }
}