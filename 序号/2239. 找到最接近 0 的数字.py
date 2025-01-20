class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        a = 0x3f3f3f3f
        for x in nums:
            if x==0:return 0
            if abs(x)<abs(a) or (x>0 and x==abs(a)):
                a=x
        return a
                