class Solution:
    def giveGem(self, gem: List[int], operations: List[List[int]]) -> int:
        for a, b in operations:
            # a 把自己宝石一半给b
            diff = gem[a] >> 1
            gem[a] -= diff
            gem[b] += diff
        return max(gem)-min(gem)