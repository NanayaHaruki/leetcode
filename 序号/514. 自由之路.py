class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        m,n=len(ring),len(key)
        d = defaultdict(list) # 保存ring中字符出现的位置
        for i ,x in enumerate(ring):
            d[x].append(i)
        @cache
        def dfs(i,j):
            '''从ring[i]找到 key[j]需要几步'''
            if j==n:return 0
            res=math.inf
            for k in d[key[j]]:
                step =math.inf
                if k>i:
                    step = min(k-i,m-k+i)+1
                else:
                    step = min(i-k,m-i+k)+1
                res = min(res,dfs(k,j+1)+step)
            return res
        return dfs(0,0)