class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        # 找和的绝对值最大的子数组
        # 解法一
        # dp[i][0]为以i结尾的子数组中，和最大的 dp[i][1]记录和最小的

        # n = len(nums)
        # dp = [[0, 0] for _ in range(n + 1)]
        # ans = 0
        # for i in range(n):
        #     dp[i + 1][0] = max(dp[i][0] + nums[i], nums[i])
        #     dp[i + 1][1] = min(dp[i][1] + nums[i], nums[i])
        #     ans = max(ans,abs(dp[i + 1][0]), abs(dp[i + 1][1]))
        # return ans

        # 优化空间
        # mn=mx=0
        # for x in nums:
        #     mx=max(mx+x,x)
        #     mn=min(mn+x,x)
        #     ans=ans(ans,abs(mx),abs(mn))
        # return ans

        # 解法二
        # 求前缀和，最大值和最小值的差就是答案了
        s=list(itertools.accumulate(nums,initial=0))
        return max(s)-min(s)