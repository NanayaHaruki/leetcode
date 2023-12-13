class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:
        ls = list(s)
        n = len(s)
        l,r=0,n-1
        while l<r:
            if ls[l]==ls[r]:
                l,r=l+1,r-1
                continue
            if ls[l]<ls[r]:
                ls[r]=ls[l]
            else:
                ls[l]=ls[r]
        return "".join(ls)
