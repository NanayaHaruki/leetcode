class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        # 拿了某层，上下层都不能拿。 就是选层
        def dfs(node:TreeNode):
            if not node:return 0,0
            selectLeft,notSelectLeft=dfs(node.left)
            selectRight,notSelectRight=dfs(node.right)
            select=node.val+notSelectLeft+notSelectRight
            notSelect=max(selectLeft,notSelectLeft)+max(selectRight,notSelectRight)
            return select,notSelect
        return max(dfs(root))