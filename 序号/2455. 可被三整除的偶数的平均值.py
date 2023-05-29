class Solution:
    def averageValue(self, nums: List[int]) -> int:
        sm=cnt=0
        for x in nums:
            if not x%6:
                sm+=x
                cnt+=1
        return  0 if not cnt else sm//cnt
