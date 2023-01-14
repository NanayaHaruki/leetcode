class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        s=set(nums)
        mx=max(s)
        ans=len(s)
        for i in range(1,mx//3+1):
            if i in s:continue
            g=0
            for j in range(i,mx+1,i):
                if j in s:
                    g=gcd(g,j)
                    if g==i:
                        ans+=1
                        break
        return ans