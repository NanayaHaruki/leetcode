class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        ans,n=0,len(arr2)
        for i in arr1:
            mn,mx=i-d,i+d
            k = bisect.bisect_left(arr2,mn)
            if bisect.bisect_right(arr2,mx)==k:
                ans+=1         
        return ans

        