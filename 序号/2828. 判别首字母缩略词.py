class Solution:
    def isAcronym(self, words: List[str], s: str) -> bool:
        if len(words)!=len(s):return False
        for i,c in enumerate(words):
            if s[i]!=c[0]:return False
        return True
