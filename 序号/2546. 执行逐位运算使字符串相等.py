class Solution:
    def makeStringsEqual(self, s: str, target: str) -> bool:
        # 01 00 10 11
        # 10 01 11 10 
        # 只要有1，就能让其他的0变1 1变0
        return ('1' in s) == ('1' in target)