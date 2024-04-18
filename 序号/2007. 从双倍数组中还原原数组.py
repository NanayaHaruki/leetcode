import sortedcontainers
class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        sd = sortedcontainers.SortedDict()
        for x in changed:
            if x in sd:sd[x]+=1
            else:sd[x]=1
        ans=[]
        while sd:
            x,cnt = sd.peekitem(-1)
            if x==0:
                if cnt%2==0:
                    sd.pop(x)
                    ans+=[0]*(cnt>>1)
                else:
                    return []
            else:
                if x%2:return []
                half = x>>1
                if half in sd:
                    sd[x]-=1
                    sd[x>>1]-=1
                    ans.append(x>>1)
                    if sd[x]==0:sd.pop(x)
                    if sd[x>>1]==0:sd.pop(x>>1)
                else:
                    return []
        return ans