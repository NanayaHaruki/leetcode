class Solution {
    val dp = LongArray(1001).also{
        it[1]=1
        it[2]=2
        it[3]=5
        val mod = 1000000007
        for(i in 4..1000){
            it[i]=(2*it[i-1]+it[i-3])%mod
        }
    }
    fun numTilings(n: Int): Int {
        return dp[n].toInt()
    }
}