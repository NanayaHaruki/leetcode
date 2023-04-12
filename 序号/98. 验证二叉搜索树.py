class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(node,mx,mn):
            if not node:
                return True
            if mn < node.val < mx:
                return dfs(node.left,node.val,mn) and dfs(node.right,mx,node.val)
            return False
        return dfs(root,2**31,-2**31-1)