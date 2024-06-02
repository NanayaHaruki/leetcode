class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        cnts = Counter(candyType)
        n = len(candyType)
        return n//2 if len(cnts)>=n//2 else len(cnts)