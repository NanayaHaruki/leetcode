class Solution:
    def countOperations(self, num1: int, num2: int) -> int:
        cnt=0
        if num1<num2:
                num1,num2=num2,num1
        while num1 and num2:           
            cnt+= num1//num2
            num1,num2=num2,num1%num2
        return cnt