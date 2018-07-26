// 跳台阶，可以跳1 可以跳2，问跳到n有多少种方式
// 1层 只有1种跳法；
// 2层 可以1层1层  也可以直接跳2层  所以有2种跳法
// 3层 的跳法其实是从1层调到3层  和从2层跳到3层 的总和
// n层的跳法 =  n-1的跳法  +   n-2的跳法
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
        	dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

