class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        @cache 
        def dfs(l,r,v):
            if l+1>r:
                return 0
            res=0
            if nums[l]+nums[l+1]==v:
                res = dfs(l+2,r,v)+1
            if nums[r]+nums[r-1]==v:
                res= max(res,dfs(l,r-2,v)+1)
            if nums[l]+nums[r]==v:
                res=max(res,dfs(l+1,r-1,v)+1)
            return res
        n=len(nums)
        return max(
            dfs(0,n-1,nums[0]+nums[-1]),
            dfs(0,n-1,nums[0]+nums[1]),
            dfs(0,n-1,nums[-1]+nums[-2])
        )