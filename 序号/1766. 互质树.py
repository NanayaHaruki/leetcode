#primes = [[] for _ in range(51)] 
MX=51
primes = [[j for j in range(1, MX) if gcd(i, j) == 1]
           for i in range(MX)]
# for i in range(51):
#     for j in range(51):
#         if gcd(i,j)==1:
#             primes[i].append(j)
class Solution:
    def getCoprimes(self, nums: List[int], edges: List[List[int]]) -> List[int]:
        n=len(nums)
        g = [[] for _ in range(n)]
        for u,v in edges:
            g[u].append(v)
            g[v].append(u)
        ans=[-1]*n
        v_depth_idx = [(-1,-1)]*MX # 0是深度  1是索引
        def dfs(x,f,depth):
            v = nums[x]
            max_depth =max_depth_idx = -1
            for p in primes[v]: # 互质中找最深的
                if v_depth_idx[p][0]>max_depth:
                    max_depth,max_depth_idx=v_depth_idx[p]
            ans[x]=max_depth_idx
            # ans[x] = max(v_depth_idx[j] for j in primes[v])[1]
            tmp = v_depth_idx[v]
            v_depth_idx[v]=(depth,x)
            for y in g[x]:
                if y==f:continue
                dfs(y,x,depth+1)
            v_depth_idx[v]=tmp
        dfs(0,-1,0)
        return ans