"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        
        l=[]
        if not root:return l
        def dfs(node):
            if node:
                l.append(node.val)
                if node.children:
                    for c in node.children:
                        dfs(c)
            else :
                l.append(None)
        dfs(root)
        return l
