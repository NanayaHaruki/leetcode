class Solution:
    def minCost(self, nums: List[int], x: int) -> int:
        # 转一圈，每次统计转过后每块巧克力的最小价格，并统计总成本
        n=len(nums)
        mn=nums.copy()
        ans=sum(mn)
        for i in range(1,n):
            for j in range(n):
                curPrice=nums[(j+i)%n]
                mn[j]=min(mn[j],curPrice)
            total=i*x+sum(mn)
            ans=min(total,ans)
        return ans