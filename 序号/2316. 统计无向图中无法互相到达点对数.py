class UF:
    def __init__(self,n:int) -> None:
        self.p=[x for x in range(n)]
        self.sz=[1]*n

    def find(self,x):
        if self.p[x]==x:
            return x
        self.p[x]=self.find(self.p[x])
        return self.p[x]
    
    def union(self,a,b):
        pa,pb=self.find(a),self.find(b)
        if pa==pb:return
        if self.sz[pa]>self.sz[pb]:
            pa,pb=pb,pa
        self.p[pa]=pb # 小的并入大的
        self.sz[pb]+=self.sz[pa]
        self.sz[pa]=0
        # print(pa,self.sz[pa],pb,self.sz[pb])

    def edges(self):
        cnt=0
        for groupSize in self.sz:
            if groupSize:
                cnt+=groupSize*(groupSize-1)//2
        return cnt

    
class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        uf = UF(n)
        for a,b in edges:
            uf.union(a,b)
        return n*(n-1)//2 - uf.edges()