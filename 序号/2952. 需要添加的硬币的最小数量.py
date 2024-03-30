class Solution:
    def minimumAddedCoins(self, coins: List[int], target: int) -> int:
        coins.sort()
        s,i,ans=1,0,0
        n = len(coins)
        while s<=target: # s表示想要现在想要获得的和
            if i==n: # 没的选了，少s就添加s
                ans+=1
                s*=2 #  # 之前获得到s -1，现在加了s，可以获得2s-1,下一次要获取的是2s-1+1 = 2s
            else:
                x = coins[i]
                if x<=s:
                    s+=x
                    i+=1
                else:
                    s*=2
                    ans+=1
        return ans
