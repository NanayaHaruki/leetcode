class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        # p 是 s 子序列，选最大的k，从s中删除removable最多的字符，使p仍然是s的子序列
        def check(s,p,t):
            f=-1
            for c in p  :
                f+=1
                while f<len(s) and (not t[f] or s[f]!=c):
                    f+=1
                if f==len(s):
                    return False
            return True
            # j=0
            # for i in range(len(s)):
            #     if t[i] and s[i]==p[j]:j+=1
            #     if j==len(p):return True
            # return False
        l,r=-1,len(removable)+1
        while l+1<r:
            m=(l+r)//2
            t=[1]*len(s)
            for i in range(m):
                t[removable[i]]=0
            if check(s,p,t):
                l=m
            else :
                r=m
        return l