# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        q = deque([root])
        ans=[]
        while q:
            sm=0
            for _ in range(len(q)):
                node = q.popleft()
                sm+=node.val
                if node.left:q.append(node.left)
                if node.right:q.append(node.right)
            ans.append(sm)
        ans.sort(reverse = True)
        return ans[k-1] if len(ans)>=k else -1
