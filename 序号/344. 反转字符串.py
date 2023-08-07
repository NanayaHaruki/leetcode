class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l,r=0,len(s)-1
        while l<r:
            ll=s[l]
            s[l]=s[r]
            s[r]=ll
            l,r=l+1,r-1
        return s
