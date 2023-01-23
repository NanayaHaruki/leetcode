from math import ceil
from typing import List
import bisect
class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        # i = bisect.bisect_right(brackets,income,lambda x:x[0])
        l,r=-1,len(brackets)
        while l+1<r:
            m=(l+r)//2
            if brackets[m][0]<=income:
                l=m
            else:
                r=m
        i=r
        ans=0
        for j in range(i+1):
            if j==0:
                ans+=brackets[j][0]*brackets[j][1]
            elif j==i: 
                ans+= (income-brackets[j-1][0])*brackets[j][1]
            else:
                ans+=(brackets[j][0]-brackets[j-1][0])*brackets[j][1]
        return ans/100
            


                    
brackets = [[3,50],[7,10],[12,25]]; income = 0

i=Solution().calculateTax(brackets,income)
print(i)