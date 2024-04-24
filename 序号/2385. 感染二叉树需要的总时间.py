class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        # 建图，重新从start出发走最长路径
        d=defaultdict(set)
        def dfs(node):
            print('dfs')
            if not node:return
            if node.left:
                d[node.val].add(node.left.val)
                d[node.left.val].add(node.val)
            if node.right:
                d[node.val].add(node.right.val)
                d[node.right.val].add(node.val)
            dfs(node.left)
            dfs(node.right)
        dfs(root)

        # bfs 一圈圈的走
        # q = deque([start])
        # vis=set()
        # ans=0
        # while q:
        #     sz = len(q)
        #     print(f'sz={sz}')
        #     print(q)
        #     for _ in range(sz):
        #         node = q.popleft()
        #         vis.add(node)
        #         for nxt in d[node]:
        #             if nxt not in vis:
        #                 q.append(nxt)
        #     ans+=1
        # return ans-1
        ans=0
        vis=set([start])
        def dfs2(node,length):
            length+=1
            ans=max(ans,length)
            vis.add(node)
            for nxt in d[node]:
                if nxt not in vis:
                    dfs2(nxt,length)
        dfs2(start,0)
        return ans-1