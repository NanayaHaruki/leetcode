class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ns,nt=len(s),len(t)
        j=0
        for i,x in enumerate(s):
            while j<nt and t[j]!=x:j+=1
            if j==nt:return False
            j+=1
        return True
