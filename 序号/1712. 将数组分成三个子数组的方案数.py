class Solution:
    def waysToSplit(self, nums: List[int]) -> int:
        # 分割成3个子数组，先求出前缀和
        n=len(nums)
        ps=[0]*n
        ps[0]=nums[0]
        for i in range(1,n):
            ps[i]=ps[i-1]+nums[i]
        ans=0
        for i in range(n-2):
            # 先找到满足mid>=left的左边界位置，再找到能够满足mid<=right的右边界位置
            l,r=i,n-1
            while l+1<r:
                m=(l+r)//2
                if ps[i]<=ps[m]-ps[i]:
                    r=m
                else:
                    l=m
            # r为左边界
            left=r
            l,r=r-1,n-1
            while l+1<r:
                m=(l+r)//2
                if ps[m]-ps[i]<=ps[-1]-ps[m]:
                    l=m
                else:
                    r=m
            ans+=l-left+1
        return ans%int(1e9+7)