class Solution:
    def halveArray(self, nums: List[int]) -> int:
        l=[]
        s=sum(nums)
        cs=s
        for x in nums:
            heapq.heappush(l,-x)
        ans=0
        while cs>s/2:
            mx = -heapq.heappop(l)
            cs-=mx/2
            heapq.heappush(l,-mx/2)
            ans+=1
        return ans