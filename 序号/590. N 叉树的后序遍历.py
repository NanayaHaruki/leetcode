"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:return []
        ans=[]
        def dfs(node):
            if not node:return
            if not node.children:
                ans.append(node.val)
            else:
                for child in node.children:
                    dfs(child)
                ans.append(node.val)
        dfs(root)
        return ans