class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        # 利用bst性质，先更改右树，再更改自身，右树已经更改好了，自身的值就是右树加自己。 
        # 左树有子节点，说明有更大的树，一样计算右树后加上自己;没有右树就用父节点的值加上自己的值
        pre=[0]
        def dfs(node):
            # 如果树还有右节点，那么和其他一样计算自身+右节点的值。如果没有了，那么自身+父节点的值
            if not node:return
            dfs(node.right)
            node.val+=pre[0]
            pre[0]=node.val
            dfs(node.left)
        dfs(root)
        return root

        # 遍历树，统计有哪些节点，存到数组中。 再计算后缀和，得出每个节点应该修改成啥。最后再遍历一遍赋值上去
        # 时间需要 3n
        # d=[0]*101
        # def dfs(node):
        #     if not node:return
        #     dfs(node.left)
        #     d[node.val]=node.val
        #     dfs(node.right)
        # dfs(root)
        # for i in range(99,-1,-1):
        #     d[i]+=d[i+1]
        # print(d[:10])
        # def dfs2(node):
        #     if not node:return
        #     dfs2(node.left)
        #     node.val=d[node.val]
        #     dfs2(node.right)
        # dfs2(root)
        # return root