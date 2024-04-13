class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        # 找入度为0的。 如果有多个返回-1
        ind = [0]*n
        for u,v in edges:
            ind[v]+=1
        ans=[]
        for i,d in enumerate(ind):
            if d==0:ans.append(i)
        return -1 if len(ans)>1 else ans[0]