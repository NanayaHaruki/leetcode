# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.st=set()
        if not root:
            self.rt=None
            return
        root.val = 0
        self.st.add(0)
        def dfs(node):
            if node.left:
                node.left.val=node.val*2+1
                self.st.add(node.left.val)
                dfs(node.left)
            if node.right:
                node.right.val=node.val*2+2
                self.st.add(node.right.val)
                dfs(node.right)
        dfs(root)



    def find(self, target: int) -> bool:
        return target in self.st


# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)