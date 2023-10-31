class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        # 从基因为1 的树往上找，父树缺少的基因值肯定比子树大，dfs调用保存所有基因值，查出缺啥，除了这条包含1的链表以外的节点都缺少1
        n=len(nums)
        ans=[1]*n
        if 1 not in nums:return ans
        # 保存每个节点有哪些直接的儿子
        g=[[] for _ in range(n)]
        for i in range(1,n):
            g[parents[i]].append(i)
        idx=nums.index[1] # 找1的节点编号，一直往上找
        vis=set()
        mn=2 # 因为从1开始找父树，最小的缺失为2
        def dfs(x):
            # 遍历所有子节点
            vis.add(nums[x])
            for son in g[x]:
                if nums[son] not in vis: # 每节点基因不重复，从vis可以判断有无走过
                    dfs(son)

        while idx>=0:
            dfs(idx)
            while mn in vis:mn+=1
            ans[idx]=mn
            idx=parents[idx]
        return ans