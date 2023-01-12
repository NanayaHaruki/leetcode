class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        for i in range(int(c**0.5)+1): # c 为i j的平方和，i大小不能超过根号c
            j=int((c-i*i)**0.5)
            if i*i+j*j==c:
                return True
        return False