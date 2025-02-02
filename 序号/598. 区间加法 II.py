class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        if not ops:return m*n
        minA,minB=inf,inf
        for a,b in ops:
            minA=min(minA,a)
            minB=min(minB,b)
        return minA*minB