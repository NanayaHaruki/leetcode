# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def isSame(a,b):
            if (a and not b) or (not a and b):return False
            if not a and not b:return True
            if a.val==b.val:
                return isSame(a.left,b.left) and isSame(a.right,b.right)
            return False
        if not root and not subRoot:return True
        if not root or not subRoot:return False
        if isSame(root,subRoot):return True
        if self.isSubtree(root.left,subRoot):return True
        return self.isSubtree(root.right,subRoot)


            
