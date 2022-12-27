class Solution:
    def minimumMoves(self, s: str) -> int:
        i,size,ans = 0,len(s),0
        while i<size:
            if s[i]=='X':
                ans+=1
                i+=3
            else :
                i+=1           
        return ans