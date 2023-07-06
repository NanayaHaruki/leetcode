class Solution:
    def maximumEvenSplit(self, finalSum: int) -> List[int]:
        if finalSum&1:
            return []
        # 从2 一直等差数列往上算就行了
        # Sn=a1*n+n(n+1)d//2   a1=2,d=2
        # Sn=n^2+n
        n=int(-0.5+((1+4*finalSum)**0.5)/2)
        ans=[]
        i=1
        while i<=n:
            ans.append(2*i)
            i+=1
        if n*n+n<finalSum:
            # 要加上个小于2i的数，可小的已经加过了，加到最后一个数上去
            ans[-1]+=(finalSum-(n*n+n))
        return ans