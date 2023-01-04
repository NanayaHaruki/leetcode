class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        # 要找出第k个独一无二的字符，必须遍历完arr才知道是不是独一无二
        d={}
        for i,s in enumerate(arr):
            if d.get(s):
                d[s][0]+=1
            else:
                d[s]=[1,i]
        l=[]
        for s,v in d.items():
            if v[0]==1:
                l.append((v[1],s))
        l.sort()
        return l[k-1][1] if len(l)>=k else ""