class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
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