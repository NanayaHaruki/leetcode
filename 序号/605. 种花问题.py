class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        # 判断左边右边都是0就行了，左右边界当边界外是0
        m=len(flowerbed)
        k=0
        for i in range(m):
            l=0 if i-1<0 else flowerbed[i-1]
            r=0 if i+1==m else flowerbed[i+1]
            if l==0 and r==0 and flowerbed[i]==0:
                flowerbed[i]=1
                k+=1
        return k>=n  