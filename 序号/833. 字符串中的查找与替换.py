class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        # 按照满足替换条件的顺序，将s切割开，替换后再合成新的字符串
        for i,x in enumerate(indices):
            indices[i]=(x,i)
        indices.sort()
        sp=[]
        pre=0
        tl=[]
        for x,i in indices:
            sr,t=sources[i],targets[i]
            if s[x:x+len(sr)]==sr:
                sp.append(s[pre:x])
                sp.append('?')
                tl.append(t)
                pre=x+len(sr)
        sp.append(s[pre:])
        j = 0
        for i,x in enumerate(sp):
            if x=='?':
                sp[i]=tl[j]
                j+=1
        return ''.join(sp)