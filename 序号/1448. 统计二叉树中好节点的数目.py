class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(node,mx):
            if not node:return 0
            if mx<=node.val:
                add=1
                mx=node.val
            else:
                add=0        
            return dfs(node.left,mx)+dfs(node.right,mx)+add
        return dfs(root,-math.inf)