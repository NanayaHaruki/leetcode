class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        m = 0
        a = x
        while x:
            m+=x%10
            x//=10
        return -1 if a%m else m