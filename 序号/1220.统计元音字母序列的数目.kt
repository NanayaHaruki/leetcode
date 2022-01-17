/** 根据aeiou 的接续，反推出aeiou前面只能是什么，方便dp状态转移  aeiou用01234替换 */
val link = arrayOf(
    intArrayOf(1, 2, 4), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(2), intArrayOf(2,3)
)

fun countVowelPermutation(n: Int): Int {
    val mod = 1_000_000_007
    // 按照接续，给定长度可以有多少种排列可能性
    // 定义dp[i][j] 为长度为i时，结尾是j的可能性为多少
    val dp = Array(n + 1) { IntArray(5) }
    // base case  长度为1的时候，aeiou都可以
    for (i in 0 until 5) dp[1][i]=1
    // 状态转移
    for (i in 2..n){
        for (j in 0 until 5){
            val preArr = link[j]
            // 长度为i，以c结尾
            preArr.forEach {
                dp[i][j]+= dp[i-1][it]
                dp[i][j] %= mod
            }

        }
    }
    var sum = 0
    dp[n].forEach {
        sum+=it
        sum%=mod
    }
    return sum
}