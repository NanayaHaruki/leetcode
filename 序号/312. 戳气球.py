class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums.insert(0,1)
        nums.append(1)
        n = len(nums)
        
        @cache
        def dfs(i,j):
            ans=0
            for k in range(i+1,j):
                ans = max(ans,dfs(i,k)+dfs(k,j)+nums[i]*nums[j]*nums[k])
            return ans
        return dfs(0,n-1)

