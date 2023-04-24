class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        def dfs(preStart,preEnd,inStart,inEnd):
            if preStart>preEnd or inStart>inEnd:
                return None
            root = TreeNode(preorder[preStart])
            if preStart==preEnd:return root
            rootIndex = inorder.index(preorder[preStart],inStart,inEnd+1)
            root.left=dfs(preStart+1,preStart+rootIndex-inStart,inStart,rootIndex-1)
            root.right=dfs(preStart+rootIndex-inStart+1,preEnd,rootIndex+1,inEnd)
            return root
        n=len(preorder)
        return dfs(0,n-1,0,n-1)