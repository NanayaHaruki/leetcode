class Solution:
    def minimumTotalPrice(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        '''统计每条trips中的路径价格之和，先统计出经过的节点有哪些'''
        # 先建表
        g=[[] for _ in range(n)]
        for a,b in edges:
            g[a].append(b)
            g[b].append(a)
        cnts=[0]*n  # 记录trips中经过的每个节点的次数
        def dfs(cur,fa,end):
            if cur==end:
                cnts[cur]+=1
                return True # 找到了
            for nxt in g[cur]:
                if nxt==fa:continue
                if dfs(nxt,cur,end):
                    cnts[cur]+=1
                    return True
            return False
        for start,end in trips:
            dfs(start,-1,end)
        # 统计好节点的经过次数了，乘上价格后，就等于求整棵树的和最小,随便找个起点就行
        def dp(cur,fa): # 返回cur减半与不减 2个结果
            not_half=cnts[cur]*price[cur]
            half=not_half//2
            for nxt in g[cur]:
                if nxt==fa:continue
                a,b=dp(nxt,cur)
                not_half+=min(a,b) # cur 没减，nxt减不减都行，选小的
                half+=a # cur 减了，下一个不能减
            return not_half,half
        return min(dp(0,-1))