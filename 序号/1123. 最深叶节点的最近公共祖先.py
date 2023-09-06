class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node:TreeNode):
            if node is None:return 0,None
            leftDepth,lnode=dfs(node.left)
            rightDepth,rnode=dfs(node.right)
            if leftDepth==rightDepth:
                return leftDepth+1,node
            elif leftDepth>rightDepth:
                return leftDepth+1,lnode
            else:
                return rightDepth+1,rnode
        return dfs(root)[1]