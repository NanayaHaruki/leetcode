class Solution:
    def waysToBuyPensPencils(self, total: int, cost1: int, cost2: int) -> int:
        mx1=total//cost1
        ans=0
        for i in range(mx1+1):
            j=(total-i*cost1)//cost2
            ans=ans+j+1
        return ans