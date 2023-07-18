class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        n1,n2=len(num1),len(num2)
        if n1>n2:
            n1,n2,num1,num2=n2,n1,num2,num1
        j=0
        ans=""
        for i in range(n2):
            if i<n1:
                a,b=int(num1[n1-1-i]),int(num2[n2-1-i])
            else:
                a,b=0,int(num2[n2-1-i])
            ans+=str((a+b+j)%10)
            if a+b+j>9:
                j=1
            else:
                j=0
        if j:
            ans+='1'
        return ans[::-1]