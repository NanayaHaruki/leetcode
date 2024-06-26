class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        n = len(nums)
        s = (1<<n) -1
        @cache
        def dfs(s,i):# s保存可以选的nums的索引，i是上次选的索引，因为这次能选啥需要用i判断
            if s==0:return 1
            ans=0
            for j in range(n):
                if (s>>j)&1==1 and (nums[j]%nums[i]==0 or nums[i]%nums[j]==0):
                    ans+=dfs(s^(1<<j),j)
            return ans
        ans = 0
        for i in range(n):
            ans+=dfs(s^(1<<i),i)
        return ans%1000000007
