from typing import List
from collections import Counter,defaultdict
import sys
import time
import functools

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
            
a=["42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"]
b=["52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5"]
print(len(a))
print(len(b))
i = Solution().findLongestSubarray(a)
print(i)