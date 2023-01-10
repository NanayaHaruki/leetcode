class Solution:
    def crackSafe(self, n: int, k: int) -> str: 
        vis=set()
        ans=[]
        len=10**(n-1)
        def dfs(u):
            for i in range(k):
                cur=u*10+i
                if cur not in vis:
                    vis.add(cur)
                    dfs(cur%len)
                    ans.append(str(i))
        dfs(0)
        ans.append('0'*(n-1))
        return "".join(ans)