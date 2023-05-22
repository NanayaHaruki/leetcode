class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        if not root:
            return None
        if not root.left and not root.right:
            return root if root.val>=limit else None
        root.left,root.right=self.sufficientSubset(root.left,limit-root.val),self.sufficientSubset(root.right,limit-root.val)
        return root if root.left or root.right else None