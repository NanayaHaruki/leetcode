class Solution:
    def findLongestSubarray(self, array: List[str]) -> List[str]:
        d = {}
        diff,l,r = 0,0,0
        for i,x in enumerate(array):
            if len(x)==1 and ord(x)>=65:
                diff+=1
            else :
                diff-=1
            if diff==0:
                l,r=0,i
            elif diff in d :      
                if i-d[diff]>r-l+1:          
                    l,r=d[diff]+1,i
            else:
                d[diff]=i
        return array[l:r+1] if r else []