class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        n=len(nums)
        p,s=[-1]*n,[-1]*n
        m = inf
        for i,x in enumerate(nums):
            if x > m:
                p[i]=m
            else:
                m=min(m,x)
        m= inf
        for i in range(n-1,-1,-1):
            if nums[i]>m:
                s[i]=m
            else:
                m=min(m,nums[i])
        m = inf
        for i in range(n):
            if p[i]!=-1 and s[i]!=-1:
                m = min(m,nums[i]+p[i]+s[i])
        return -1 if m==inf else m
            # 数据量小，周赛直接暴力
        # n = len(nums)
        # ans=inf
        # for i in range(n):
        #     for j in range(i+1,n):
        #         for k in range(j+1,n):
        #             if nums[i]<nums[j] and nums[j]>nums[k]:
        #                 ans=min(ans,nums[i]+nums[j]+nums[k])
        # return -1 if ans == inf else ans