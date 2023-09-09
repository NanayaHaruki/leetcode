class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 典型拓扑排序
        # 统计入度，将入度0保存成Queue并一直更新
        # 用List保存路径
        # 不断从Q中取出节点n，放入L，并删除n所有边
        ins=[0]*numCourses
        g={}
        for a,b in prerequisites:
            ins[b]+=1
            if a in g:
                g[a].append(b)
            else:
                g[a]=[b]
        q=deque()
        l=[]
        for i,x in enumerate(ins):
            if x==0:q.append(i)
        while q:
            u = q.pop()
            l.append(u)
            if u not in g: continue
            for v in g[u]:
                ins[v]-=1
                if ins[v]==0:
                    q.append(v)
        return len(l)==numCourses