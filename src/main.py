from typing import List
from collections import Counter,defaultdict

class Solution:
    def findLengthOfShortestSubarray(self, nums: List[int]) -> int:
        n=len(nums)
        l,r=0,n-1
        while l+1<n and nums[l+1]>=nums[l]:l+=1
        while r-1>=0 and nums[r-1]<=nums[r]:r-=1
        if l>=r: # 两个非递减有交叉，说明整体非递减
            return 0
        # 枚举每一个左端点i，在右侧找符合条件的最小位置j，删除[i+1,j-1]中间的数
        ans=min(n-l-1,r) # 保留左边，总共n个数，左边l+1个数，需要删掉n-(l+1);保留右边，需要删掉[0,r-1],长度为r
        for i in range(l+1):
            while r <n and nums[r]<nums[i]:
                r+=1
            ans=min(ans,r-i-1)
        return ans


l=[16,10,0,3,22,1,14,7,1,12,15]
i = Solution().findLengthOfShortestSubarray(l)
print(i)

