class Solution {
    fun numTrees(n: Int): Int {
        // 以i为head节点的个数 = 以i-1的个数+1
        // 有5个节点的数的个数= 左树0个节点 右树4个节点 + 左树1 有数3 +左树2 右树2 + 左树3 右树1 +左树4 右树0
        val dp = IntArray(n+1)
        dp[0]=1
        dp[1]=1
        for (i in 2..n){
            for (j in 0 until i){
                dp[i]+= dp[j]*dp[i-1-j]
            }
        }
        return dp[n]
    }
}