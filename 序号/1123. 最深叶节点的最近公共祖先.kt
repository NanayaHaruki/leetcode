/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    private fun dfs(node:TreeNode?):Int{
        if(node==null) return 0
        return max(dfs(node?.left),dfs(node?.right))+1
    }
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        // 左右深度相等，当前就是共同祖先，否则谁更深就递归更深的
        if(root==null) return null
        val l = dfs(root?.left)
        val r = dfs(root?.right)
        if(l==r) return root
        if(l>r) return lcaDeepestLeaves(root?.left)
        return lcaDeepestLeaves(root?.right)
    }
}