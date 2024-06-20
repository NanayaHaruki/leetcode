class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        ans = 0
        cnt = [0] * 10
        for x in nums:
            for y, c in enumerate(cnt):
                if c and gcd(y, x % 10) == 1:
                    ans += c
            while x >= 10: 
                x //= 10
            cnt[x] += 1  # 统计最高位的出现次数
        return ans
    
class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        def gcd(a,b):
            return a if not b else gcd(b,a%b)
        ans=0
        for i,x in enumerate(nums):
            for j in range(i+1,len(nums)):
                if gcd(int(str(x)[0]),nums[j]%10)==1:
                    ans+=1
        return ans