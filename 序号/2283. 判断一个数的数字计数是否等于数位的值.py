class Solution:
    def digitCount(self, num: str) -> bool:
        d=[0]*10
        for i,x in enumerate(num):
            d[i]-=int(x)
            d[int(x)]+=1
        for i in range(10):
            if d[i]:
                return False
        return True