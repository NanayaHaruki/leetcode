class Solution {
    fun getMoneyAmount(n: Int): Int {
        // 在1.n之间猜数字，猜x 错了要支付x元，但能知道大小
        // 定义dp[i][j]为从i-j需要支付多少可以确保猜对
        // 猜x后，知道小了，那么还需要在x+1,n之间猜。知道大了需要在1，x-1之间猜
        // 所以在猜完x之后，为了确保猜中，需要准备的钱是x+max(dp[1,x-1],dp[x+1,n]
        // x是会变化的，所以dp[i][j]会被多次赋值，存最小的。
        val dp = Array(n+2){IntArray(n+2)}
        for (i in n-1 downTo 1){
            //左边，倒序是因为7-10 猜8,7-7 9-10,左右区间都跑过了
            // 而正序遍历的话，计算1-5的时候，猜4 1-3遍历过了，5-5的5因为大于1了，还没走到
            for (j in i+1..n){ // 右边
                var cost = Int.MAX_VALUE
                for (k in i..j){ // 在i,j范围内移动的x
                    val need = k+ maxOf(dp[i][k-1],dp[k+1][j])
                    cost = minOf(cost,need)
                }
                dp[i][j]=cost
            }
        }
        return dp[1][n]
    }
}