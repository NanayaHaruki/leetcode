class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> List[int]:
        # 一元二次方程
        if tomatoSlices%2:return []
        t=tomatoSlices//2-cheeseSlices
        c=cheeseSlices-t
        return [t,c] if t>=0 and c>=0 else []