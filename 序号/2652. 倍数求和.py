class Solution:
    def sumOfMultiples(self, n: int) -> int:
        # 能被2 整除的数，必定是等差数列，根据等差数列求和公式可以求出
        def sum(x):
            first=x
            last=n//x*x
            count=n//x
            return (first+last)*count//2
        return sum(3)+sum(5)+sum(7)-sum(15)-sum(21)-sum(35)+sum(15*7)
        # a=0
        # for i in range(1,n+1):
        #     if i%3==0 or i%5==0 or i%7==0:
        #         a+=i
        # return a