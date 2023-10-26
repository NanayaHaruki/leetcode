class Solution:
    def countDigits(self, num: int) -> int:
        x=num
        ans=0
        while num:
            mod=num%10
            num//=10
            if x%mod==0:ans+=1
        return ans
