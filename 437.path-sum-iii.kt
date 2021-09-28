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
class Solution() {
    var ans = 0
    var target = 0
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        target = targetSum
        // 遍历每个点，然后从每个点往下找，一直到遍历完（
        // 并不是找到就可以返回，因为一条线上可能有正有负，前面已经target了，后面可能++--会在此出现）
        dfs1(root)
        return ans
    }
    /**
     * @param node 当前节点
     * @param sum，这条线，遍历到当前节点之前，所有父节点的和
     * */
    fun dfs(node: TreeNode?, sum: Int) {
        if (node == null) return
        val newSum = node.`val` + sum
        if (newSum == target) {
            ans++
        }
        dfs(node.left, newSum)
        dfs(node.right, newSum)
    }

    fun dfs1(node: TreeNode?) {
        if (node == null) return
        if (node.`val`==target) ans++
        dfs(node.left, node.`val`) // 计算从这个点出发的target
        dfs(node.right, node.`val`) // 计算从这个点出发的target
        // 遍历其他节点
        dfs1(node.left)
        dfs1(node.right)
    }
}