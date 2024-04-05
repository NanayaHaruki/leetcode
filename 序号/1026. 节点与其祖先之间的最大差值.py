# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        ans = 0
        def dfs(x,mx,mn):
            if not x: # 递归到空，这条线的极值就是参数了，更新答案
                nonlocal ans
                ans = max(ans,mx-mn)
            mx=max(mx,x.val)
            mn=min(mn,x.val)
            dfs(x.val,mx,mn)
            dfs(x.val,mx,mn)
        dfs(root,root.val,root.val)
        return ans
    
        def dfs(x):
            mx = mn = x.val
            diff = 0
            if x.left:
                lmx,lmn,ldiff = dfs(x.left)
                mx=max(mx,lmx)
                mn=min(mn,lmn)
                diff = max(abs(x.val-lmx),abs(x.val-lmn),ldiff)
                # print(x.val,diff)
            if x.right:
                rmx,rmn,rdiff = dfs(x.right)
                mx=max(mx,rmx)
                mn=min(mn,rmn)
                diff = max(abs(x.val-rmx),abs(x.val-rmn),diff,rdiff)
                # print(x.val,diff)
            return (mx,mn,diff)
        return dfs(root)[2]
        
        ans=[0]
        def dfs(node):
            if not node:
                return None
            mx,mn=node.val,node.val
            
            l= dfs(node.left)
            r=dfs(node.right)
            if l:
                mx=max(mx,l[0])
                mn=min(mn,l[1])
                ans[0]=max(ans[0],abs(l[0]-node.val),abs(l[1]-node.val))
            if r:
                mx=max(mx,r[0])
                mn=min(mn,r[1])
                ans[0]=max(ans[0],abs(r[0]-node.val),abs(r[1]-node.val))
            return (mx,mn)
        dfs(root)
        return ans[0]