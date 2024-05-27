class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        ans = [1]*n
        targetSum = mean*(m+n)
        curSum = sum(rolls)

        # 放1个就超了， 或者  放6个都不够
        if curSum+n > targetSum or curSum+n*6<targetSum:
            return []
        remain = targetSum-curSum-n
        for i in range(n):
            if remain<=5:
                ans[i]+=remain
                break
            remain-=5
            ans[i]=6
        return ans