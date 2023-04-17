class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ns,np=len(s),len(p)
        ans=[]
        l=r=0
        valid = 0
        t,w=Counter(p),Counter()
        while r<ns:
            rc = s[r]
            w[rc]+=1
            if w[rc]==t[rc]:
                valid+=1 # 窗口内这个字符的出现次数与目标相同了
            if valid==len(t):
                ans.append(l)
            r+=1
            while r-l>=np:
                lc=s[l]
                l+=1
                if w[lc]==t[lc]:
                    valid-=1
                w[lc]-=1
        return ans