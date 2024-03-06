class Solution:
    def findKOr(self, nums: List[int], k: int) -> int:
        ans=0
        for i in range(32):
            f = 1 << i
            cnt=0
            for x in nums:
                if (x & f) == f:cnt+=1
            if cnt>=k:
                ans+=f
        return ans
