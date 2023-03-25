class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        '''
        找到两边的非递减，遍历左端点，二分找右边
        '''
        # 找到左边递增的右边界和右端的左边界
        n=len(arr)
        i,j=0,n-1
        while i<n-1 and arr[i]<=arr[i+1]:i+=1
        if i==n-1:return 0
        while j>0 and arr[j-1]<=arr[j]:j-=1
        # i 为左侧有端点   j 为右侧左端点
        l,ans=0,min(n-i-1,j)
        for l in range(i+1):
            fixR = bisect.bisect_left(arr,arr[l],j,n)
            ans=min(ans,fixR-l-1)
        return ans
    

    def findLengthOfShortestSubarray(self, nums: List[int]) -> int:
        '''
        找到两边的非递减，遍历左端点，线性找右端点
        '''
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