class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        f = {} # 定义f[i][j] 以x结尾，相邻相等次数为j的最大长度
        mx = [0]*(k+1)
        for x in nums:
            if x not in f:
                f[x]=[0]*(k+1)
            for j in range(k,-1,-1):
                f[x][j]=max(f[x][j],mx[j-1] if j>0 else 0)+1
                mx[j]=max(mx[j],f[x][j])
        return mx[-1]
