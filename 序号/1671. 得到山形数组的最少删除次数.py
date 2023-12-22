class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        # 求正反的LIS
        n=len(nums)
        def LIS(nums):
            g=[]
            ans=[0]*n
            for i,x in enumerate(nums):
                idx = bisect_left(g,x)
                if idx==len(g):
                    g.append(x)
                else:
                    g[idx]=x
                ans[i]=idx+1
            return ans
        prefix=LIS(nums)
        suffix=LIS(nums[::-1])[::-1]
        ans=n
        for i in range(n):
            if prefix[i]>1 and suffix[i]>1:
                ans=min(ans,n-(prefix[i]+suffix[i]-1))
        return ans