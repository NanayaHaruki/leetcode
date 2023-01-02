class Solution:
    def repeatedCharacter(self, s: str) -> str:
        l=[0]*26
        for c in s:
            l[ord(c)-ord('a')]+=1
            if l[ord(c)-ord('a')] ==2:
                return c
        return '0'