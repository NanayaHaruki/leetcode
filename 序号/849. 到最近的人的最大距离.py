class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        ans,pre=0,-1
        for i,x in enumerate(seats):
            if x==1:
                if pre==-1:
                    ans=i
                else:
                    if i-pre>1:
                        ans=max(ans,(i-pre)//2)
                pre=i
        if seats[-1]==0:
            ans=max(ans,len(seats)-1-pre)
        return ans