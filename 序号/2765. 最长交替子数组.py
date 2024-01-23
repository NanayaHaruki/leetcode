class Solution:
    def alternatingSubarray(self, nums: List[int]) -> int:
        n=len(nums)
        mx=-1
        f = [[1,0] for _ in range(n)] # f[i][0] 表示前i个数，以i-1为结尾，且下降的最大长度  f[i][1]表示i-1结尾，且上升的长度
        for i in range(1,n):    
            if nums[i-1]+1==nums[i]:
                f[i][1]=max(2,f[i-1][0]+1) # 子数组必须s[1]=s[0]+1,长度至少是2
            elif nums[i-1]-1==nums[i]:
                f[i][0]=f[i-1][1]+1  # 不可以作为子数组的开头
            cur = max(f[i])
            if cur>1:
                mx=max(mx,cur)
        return mx