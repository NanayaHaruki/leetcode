class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        r=bisect.bisect_left(arr,x)
        l=r-1
        n=len(arr)
        while k:
            if l==-1:
                r+=1
            elif r==n:
                l-=1
            else:
                if x-arr[l]<=arr[r]-x:
                    l-=1
                else:
                    r+=1
            k-=1
        return arr[l+1:r]