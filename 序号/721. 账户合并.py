class UF:
    def __init__(self,n):
        self.p=[i for i in range(n)]
    
    def union(self,i,j):
        pi,pj = self.find(i),self.find(j)
        if pi==pj:return
        self.p[pi]=self.p[pj]

    def find(self,x):
        if self.p[x]!=x:
            self.p[x]=self.find(self.p[x])
        return self.p[x]

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        e2n = {}
        e2i = {}
        for account in accounts:
            name = account[0]
            for i in range(1,len(account)):
                email = account[i]
                if email not in e2n: # 将email和索引与名字绑定
                    e2n[email]=name
                    e2i[email]=len(e2i)
        # 连接
        uf = UF(len(e2i))
        for account in accounts:
            idx = e2i[account[1]]
            for i in range(2,len(account)):
                uf.union(idx,e2i[account[i]])
        # 分组
        groups = {}
        for e,i in e2i.items():
            root = uf.find(i)
            if root not in groups:
                groups[root]=[e]
            else:
                groups[root].append(e)
        ans = []
        for group in groups.values():
            cur = [e2n[group[0]]] # 第1个是名字
            # 再加上全组的email
            cur+=sorted(group)
            ans.append(cur)
        return ans

