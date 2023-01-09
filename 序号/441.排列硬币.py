class Solution:
    # def arrangeCoins(self, n: int) -> int:
    #     # 设可以形成k行，需要硬币数量为 （1+k)*k/2 二分检查n够不够
    #     l,r=1,int(2**31-1)
    #     while l<=r:
    #         k=l+((r-l)>>1)
    #         s=(1+k)*k>>1
    #         if s>n:
    #             r=k-1
    #         else :
    #             l=k+1
    #     return r

    def arrangeCoins(self, n: int) -> int:
        # 直接解方程 k^2+k-2n=0
        return int(-1+(1+8*n)**0.5)>>1