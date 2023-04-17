class Solution:
    def minWindow(self, s: str, p: str) -> str:
        # 求最小子串，满足t的排列
        l=r=valid=0
        n=len(s)
        t,w=Counter(p),Counter()
        ansLeft,ansRight=0,n+1
        while r<n:
            rc=s[r]
            r+=1
            w[rc]+=1
            if w[rc]==t[rc]:
                valid+=1

            while valid==len(t):
                if r-l<ansRight-ansLeft:
                    ansLeft,ansRight=l,r
                lc=s[l]
                l+=1
                if w[lc]==t[lc]:
                    valid-=1
                w[lc]-=1
        return "" if ansRight==n+1 else s[ansLeft:ansRight]