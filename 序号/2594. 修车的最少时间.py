class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        l,r=0,max(ranks)*cars*cars+1 # 最慢的人修所有的车，求的是最大时间
        # 二分时间，检查每个人修的车的数量能否修完 ranks[i]*n^2=time  n=(time/ranks[i])**0.5
        while l+1<r:
            m=(l+r)//2
            totalCars=0
            for x in ranks:
                totalCars+=int((m/x)**0.5)
                if totalCars>=cars:break
            if totalCars>=cars:
                r=m
            else:
                l=m
        return r