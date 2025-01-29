class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        d = {}
        for i,x in enumerate(nums):
            if x in d:
                if i-d[x]<=k:
                    return True
                d[x]=i
            else:
                d[x]=i
        return False