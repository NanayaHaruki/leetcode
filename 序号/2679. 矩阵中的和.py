class Solution:
    def matrixSum(self, nums: List[List[int]]) -> int:
        m,n=len(nums),len(nums[0])
        for i in range(m):
            nums[i].sort()
        ans=0
        for j in range(n-1,-1,-1):
            mx=-math.inf
            for i in range(m):
                mx=max(mx,nums[i][j])
            ans+=mx
        return ans