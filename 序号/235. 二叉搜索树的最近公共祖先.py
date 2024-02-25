class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right,p,q)
        return root
    
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val > q.val:p,q=q,p
        def dfs(node):
            if not node:return None
            if p.val == node.val or q.val==node.val:return node
            if p.val < node.val and q.val < node.val:return dfs(node.left)
            if p.val > node.val and q.val > node.val:return dfs(node.right)
            if p.val < node.val and q.val > node.val:return node
        return dfs(root)