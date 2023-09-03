class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        for i,x in enumerate(dist):
            if x%speed[i]==0:dist[i]=x//speed[i]
            else:dist[i]=x//speed[i]+1
        dist.sort()
        l,r=-1,len(dist)
        ans=0
        for i,x in enumerate(dist):
            if i<x:
                ans+=1
            else:
                break
        return ans
