# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:return []
        q=deque([root])
        ans=[]
        left2right=True
        while q:
            layer = []
            for _ in range(len(q)):
                node = q.popleft()
                if node.left:q.append(node.left)
                if node.right:q.append(node.right)
                layer.append(node.val)
            if left2right:
                ans.append(layer)
            else:
                ans.append(layer[::-1])
            left2right=not left2right
        return ans