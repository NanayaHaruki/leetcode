class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        c1,c2=Counter(words1),Counter(words2)
        return sum(v==1 and c2[k]==1 for k,v in c1.items())