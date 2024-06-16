class Solution:
    def findLUSlength(self, a: str, b: str) -> int:
        la,lb=len(a),len(b)
        if a==b:return -1
        return max(la,lb)