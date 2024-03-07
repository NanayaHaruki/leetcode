class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        r = 0
        div=[0]*len(word)
        for i,c in enumerate(word):
            r = (r*10+int(c)) % m
            div[i]= 1 if r%m==0 else 0
        return div