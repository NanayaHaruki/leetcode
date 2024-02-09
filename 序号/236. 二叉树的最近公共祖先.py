# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:return None
        if root.val == p.val:return p
        if root.val == q.val:return q
        
        l = self.lowestCommonAncestor(root.left,p,q)
        r = self.lowestCommonAncestor(root.right,p,q)
        if l and r:
            return root
        if l:
            return l
        return r     
# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if not root or root is p or root is q:return root
#         l,r=self.lowestCommonAncestor(root.left,p,q),self.lowestCommonAncestor(root.right,p,q)
#         if l and r:
#             return root
#         return l if l else r
