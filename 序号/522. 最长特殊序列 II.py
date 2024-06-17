class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def issub(a,b):
            if len(a)>len(b):return False
            i=0
            for c in b:
                if a[i]==c:
                    i+=1
                    if i==len(a):
                        return True
            return False
        ans=-1
        for i,s in enumerate(strs):
            if len(s)<=ans:continue
            f=False
            for j,t in enumerate(strs):
                if i==j:continue
                if issub(s,t):
                    f=True
                    break
            if not f:
                ans=max(ans,len(s))
        return ans