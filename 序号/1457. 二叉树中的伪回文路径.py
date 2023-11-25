class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        '''找路径可以组成回文的数量'''
        d=Counter()
        # 能组成回文 要求路径上所有点出线次数为奇数的最多1个
        def dfs(node):
            d[node.val]+=1
            if not node.left and not node.right:
                # 这里就是叶子了，判断v中的数字能否组成回文
                findOdd=False
                for v in d.values():
                    if v&1:
                        if findOdd:
                            d[node.val]-=1
                            return 0
                        else:findOdd=True
                d[node.val]-=1
                return 1
            ans=0
            if node.left:ans+=dfs(node.left)
            if node.right:ans+=dfs(node.right)
            d[node.val]-=1
            return ans
        return dfs(root)