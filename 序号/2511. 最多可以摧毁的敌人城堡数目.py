class Solution:
    def captureForts(self, forts: List[int]) -> int:
        ans,pre=0,-1
        for i,x in enumerate(forts):
            if x==0:continue
            if pre>-1 and x!=forts[pre]:
                ans=max(ans,i-pre-1)
            pre=i
        return ans