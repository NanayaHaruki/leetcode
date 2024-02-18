"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

# 24.02.18
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans=[]
        def dfs(root):
            if not root:return
            ans.append(root.val)
            for child in root.children:
                dfs(child)
        dfs(root)
        return ans
# class Solution:
#     def preorder(self, root: 'Node') -> List[int]:
        
#         l=[]
#         if not root:return l
#         def dfs(node):
#             if node:
#                 l.append(node.val)
#                 if node.children:
#                     for c in node.children:
#                         dfs(c)
#             else :
#                 l.append(None)
#         dfs(root)
#         return l
