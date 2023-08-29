class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        ''' 非叶节点的值为子节点之积 '''
        s = set(arr)
        arr.sort()
        @cache
        def dfs(x:int):
            res=1
            for i in arr:
                if i*i>x:break
                if i*i==x:
                    res+=dfs(i)**2
                    break
                if x%i==0 and x//i in s:
                    res+=dfs(i)*dfs(x//i)*2
            return res
        ans=0
        for x in arr:
            ans+= dfs(x)
            print(f'{x} {dfs(x)}')
        return ans%int(1e9+7)