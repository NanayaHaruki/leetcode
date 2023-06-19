class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        # dp 
        # 这个数%3=0，必定是结果，继续求后面的数
        n=len(nums)

        def nextMod(cur,mod):
            if cur==1: # 现在是1 
                if mod==0: # 目标是0
                    return 2 # 后面要2
                elif mod==1:
                    return 0 
                else:
                    return 1
            else:
                if mod==0:
                    return 1
                elif mod==1:
                    return 2
                else:
                    return 0
        @cache
        def dfs(i,mod):
            ''' [i,n-1] 模mod的最大和 '''
            ans=0
            if i==n:
                ans= -math.inf if mod else 0
                print(i,mod,ans)
                return ans
            if nums[i]%3==0:
                ans= nums[i]+dfs(i+1,mod)
            elif nums[i]%3==1:
                ans= max(dfs(i+1,mod),dfs(i+1,nextMod(1,mod))+nums[i])
            else:
                ans= max(dfs(i+1,mod),dfs(i+1,nextMod(2,mod))+nums[i])
            print(i,mod,ans)
            return ans
        return dfs(0,0)