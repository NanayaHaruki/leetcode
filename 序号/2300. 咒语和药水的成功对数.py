class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m,n=len(spells),len(potions)
        ans=[0]*m
        for i in range(m):
            s=spells[i]
            l,r=-1,n
            while l+1<r:
                mid=(l+r)//2
                if s*potions[mid]>=success:
                    r=mid
                else:
                    l=mid
            ans[i]=n-r
        return ans