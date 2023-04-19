class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n=len(arr)
        dp=[0]*(n+1)
        for i in range(1,n+1):# i 为前几个数能拿到的最大值
            mx=0
            for j in range(1,min(i,k)+1): # j 为包括arr[i-1]的数，最后一组的长度
                mx=max(mx,arr[i-j])
                dp[i]= max(dp[i],mx*j+dp[i-j])
        return dp[-1]