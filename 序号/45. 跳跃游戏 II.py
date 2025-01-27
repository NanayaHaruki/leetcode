class Solution:
    def jump(self, nums: List[int]) -> int:
        ans = 0
        cur = 0
        nxt = 0
        for i,x in enumerate(nums):
            if i == len(nums)-1:break
            nxt = max(nxt,i+x)
            if i==cur:
                ans+=1
                cur = nxt
        return ans