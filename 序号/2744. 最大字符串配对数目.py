class Solution:
    def maximumNumberOfStringPairs(self, words: List[str]) -> int:
        d={}
        res=0
        for w in words:
            if w[0]>w[-1]:
                w=w[::-1]
            if w in d:
                res+=d[w]
                d[w]+=1
            else:
                d[w]=1
        return res