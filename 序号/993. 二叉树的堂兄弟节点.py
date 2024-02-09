# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque([root])
        while q:
            sz = len(q)
            st=set()
            for _ in range(sz):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                    node.left.f=node
                if node.right:
                    q.append(node.right)
                    node.right.f=node
                st.add(node)
            nodeX,nodeY = None,None
            for node in st:
                if node.val==root:break
                if node.val==x :nodeX=node
                if node.val==y:nodeY=node
            if nodeX and nodeY and nodeX.f!=nodeY.f:
                return True
        return False