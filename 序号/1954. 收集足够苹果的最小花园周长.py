class Solution:
    def minimumPerimeter(self, neededApples: int) -> int:
        def sum(x):
            return 4*x**3+6*x**2+2*x # 
        l,r=0,neededApples
        while l+1<r:
            mid = (l+r)//2
            if sum(mid)<neededApples:
                l=mid
            else:
                r=mid
        return 8*r