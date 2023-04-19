class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2.sort()
        inf=math.inf
        
        @cache
        def dfs(i,k):
            '''[0,i]范围内递增，且arr[i]<k 所需操作数'''
            if i==-1:
                return 0
            ans=inf
            # 不替换
            if arr1[i]<k:
                ans= dfs(i-1,arr1[i])
            # 当前的更大,需要在arr2中找一个替换
            idx=bisect.bisect_left(arr2,k)-1
            if idx>=0:
                ans=min(ans,dfs(i-1,arr2[idx])+1)
            return ans
        ans=dfs(len(arr1)-1,inf)
        return ans if ans<inf  else -1