import kotlin.math.abs

class Solution {
    var ans = 0
    fun findTilt(root: TreeNode?): Int {
        // 节点坡度为左右树节点数量
        if (root == null) return 0
        val l = dfs(root.left)
        val r = dfs(root.right)
        return ans+abs(l-r)
    }

    /** 返回节点和 */
    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0
        val sumL = dfs(node.left)
        val sumR = dfs(node.right)
        ans += abs(sumL - sumR)
        println("${node.`val`} $ans")
        return node.`val` + sumL + sumR
    }
}