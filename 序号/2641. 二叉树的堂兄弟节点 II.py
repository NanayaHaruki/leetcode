# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q=deque([root])
        while q:
            sz=len(q)
            sm=0
            l=[]
            for _ in range(sz):
                node =q.popleft()
                node.sumOfSon=0
                l.append(node)
                sm+=node.val
                if node.left:
                    q.append(node.left)
                    node.left.f=node
                    node.sumOfSon+=node.left.val
                if node.right:
                    q.append(node.right)
                    node.right.f=node
                    node.sumOfSon+=node.right.val
            for x in l:
                if x==root:
                    x.val=0
                    break
                x.val=sm-x.f.sumOfSon
        return root