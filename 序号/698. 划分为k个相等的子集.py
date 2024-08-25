class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        _sum = sum(nums)
        n = len(nums)
        if _sum % k != 0:
            return False
        avg = _sum // k
        nums.sort(reverse=True)
        vis = [False]*n
        def dfs(i,j,s):
            # i 为球的索引，j为桶的索引，s为之前这个桶已经装了多少
            if s==avg:
                return True if j==k-1 else dfs(0,j+1,0)
            # 这玩意要放在s==avg的判断下面。
            # 因为最后一个球满足了最后一个桶时，i==n,j=k,s=avg,此时满足条件
            if i==n: 
                return False
            for idx in range(i,n):
                if s+nums[idx]>avg or vis[idx]:
                    continue
                vis[idx]=True
                if dfs(idx+1,j,s+nums[idx]):
                    return True
                vis[idx]=False
                # 如果这个球作为第1个球都放不进桶，那么整个数组都不合法了
                if s == 0:
                    return False
            return False
        return dfs(0,0,0)
                
