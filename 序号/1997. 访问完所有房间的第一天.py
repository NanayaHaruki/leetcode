class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        # 访问i奇数次，下次访问nextVisit[i]，nextVisit[i]还不大于i，也就是曾经访问过的
        # 访问i偶数次，下次访问i+1
        # 第1次访问i时，[0,i-1]必定都是偶数次。想访问i+1必定要再次访问i
        # 那么从nextVisit[i]的经过天数和到i的天数做差就知道第2次需要多久
        # 动态规划往后推，时间O(n)
        n=len(nextVisit)
        f = [0]*n # 存第1次到i的天数
        f[1]=2
        for i in range(2,n):
            # 到i 需要i-1访问过2次，第1次是f[i-1]，第2次需要f[i-1]-f[nextVisit[i-1]]
            f[i]=(f[i-1]*2-f[nextVisit[i-1]]+2)%1_000_000_007
        return f[-1]