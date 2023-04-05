class Solution:
    def gcd(a,b):
        return a if b==0 else gcd(b,a%b)

    def commonFactors(self, a: int, b: int) -> int:
        mx = gcd(a,b)
        ans=0
        for i in range(1,mx+1):
            if a%i==0 and b%i==0:
                ans+=1
        return ans