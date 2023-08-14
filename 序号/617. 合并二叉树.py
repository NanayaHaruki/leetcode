class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root1:return root2
        if not root2:return root1
        if root1:
            root1.val+=root2.val
            root1.left,root1.right=self.mergeTrees(root1.left,root2.left),self.mergeTrees(root1.right,root2.right)
        else:
            return None
        return root1