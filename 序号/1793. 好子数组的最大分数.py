class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        q = [(0,-1)]
        nums.append(0)
        ans = 0
        for i,r in enumerate(nums):
            while q and r < q[-1][0]:
                h,_ = q.pop()
                l,j = q[-1]
                if j<k<i:
                    ans=max(ans,h*(i-j-1))
            q.append((r,i))
        return ans