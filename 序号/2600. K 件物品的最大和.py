class Solution:
    def kItemsWithMaximumSum(self, numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
        ans=0
        if numOnes>=k:
            return k
        k-=numOnes
        if numZeros>=k:
            return numOnes
        k-=numZeros
        return numOnes-k
