"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:return []
        ans=[]
        q = deque([root])
        while q:
            l = []
            for _ in range(len(q)):
                node = q.popleft()
                l.append(node.val)
                if not node.children:continue
                for child in node.children:
                    q.append(child)
            ans.append(l)
        return ans