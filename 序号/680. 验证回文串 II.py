class Solution:
    def validPalindrome(self, s: str) -> bool:
        l,r=0,len(s)-1
        a=b=0
        while l<r:
            if s[l]==s[r]:
                l+=1
                r-=1
            else:
                if a==0:
                    a=1
                    l+=1
                else:
                    a=2
                    break
        l,r=0,len(s)-1
        while l<r:
            if s[l]==s[r]:
                l+=1
                r-=1
            else:
                if b==0:
                    b=1
                    r-=1
                else:
                    b=2
                    break
        if a==2 and b==2:
            return False
        return True