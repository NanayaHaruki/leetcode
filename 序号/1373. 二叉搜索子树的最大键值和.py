class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        # 在bst子树中，找到val和最大的
        ans=0
        def dfs(root):
            '''
            是bst,返回1,sum,mx,mn  sum用于上层累计和,mx,mn用于判断子树是否bst
            非bst,返回0,0
            '''
            nonlocal ans
            if not root:
                return (1,0,None,None)
            # 自己不是bst，子树可能是，要后序遍历
            retL,retR=dfs(root.left),dfs(root.right) 
            if retL[0] and retR[0] \
                and (not retL[2] or retL[2]<root.val) \
                and (not retR[3] or retR[3]>root.val):
                sum=retL[1]+retR[1]+root.val
                ans=max(ans,sum)
                return (1,sum,retR[2] if retR[2] else root.val,retL[3] if retL[3] else root.val)
            return (0,0)
        dfs(root)
        return ans