class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        if not root:
            return []
        st=set(to_delete)
        fake=TreeNode(0)
        fake.left=root
        ans=[]
        if root.val not in st:
            ans.append(root)
        def dfs(node,p,isLeft):
            if not node:
                return
            l,r,v=node.left,node.right,node.val
            if v in st:
                if isLeft:
                    p.left=None
                else:
                    p.right=None
                if l and l.val not in st:
                    ans.append(l)
                if r and r.val not in st:
                    ans.append(r)
        
            dfs(l,node,True)
            dfs(r,node,False)
        dfs(root,fake,True)
        return ans