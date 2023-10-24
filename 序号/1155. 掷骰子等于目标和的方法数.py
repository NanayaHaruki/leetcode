class Solution:
    @cache
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        # 用n个骰子，骰子数目[1,k]，扔出target的方案数量
        if target<=0:
            return 0
        if n==1:
            return 1 if target<=k else 0
        ans=0
        for i in range(1,k+1):
            ans+=self.numRollsToTarget(n-1,k,target-i)
            ans%=int(1e9+7)
        return ans