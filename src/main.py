from typing import List
from collections import Counter,defaultdict

class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        d = defaultdict(int)
        ans=0
        for i in nums:
            for j in nums:
                d[i & j]+=1
        for i in nums:
            for j in d:
                if i&j==0:
                    ans+=d[i&j]
        return ans









        



