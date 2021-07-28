class Solution {
    val ans = mutableListOf<Int>()
    val p_map = mutableMapOf<TreeNode, TreeNode>()
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        // 求二叉树中指定节点，固定半径内的所有值
        // 如果只是找左右节点，dfs即可，但指定节点半径需要找到父节点，所以需要遍历二叉树，将父节点存起来或连接起来
        findParent(root)
        findAns(target,0,k,null)
        return ans
    }

    fun findParent(root: TreeNode?) {
        if (root == null) return
        if (root.left != null) {
            p_map[root.left!!] = root
        }
        if (root.right != null) {
            p_map[root.right!!] = root
        }
        findParent(root.left)
        findParent(root.right)
    }

    /**
     * @param node 当前深度需要判断的节点
     * @param curDistance 这个node与target的距离
     * @param k 题目要求的距离
     *
     * 因为每个节点需要找left，right，也要找parent，
     * 所以为了避免往下找了一层，又往上找回来了。 或往上找了一步，又往下找
     * 参数多传一个from，避免路线重复
     * */
    fun findAns(node: TreeNode?, curDistance: Int, k: Int, from: TreeNode?) {
        if (node == null) return
        if (curDistance == k) {
            ans.add(node.`val`)
            return
        }
        if (node.left != from) findAns(node.left, curDistance + 1, k, node)
        if (node.right != from) findAns(node.right, curDistance + 1, k, node)

        val parent = p_map[node]
        if (parent != from) {
            findAns(parent, curDistance + 1, k, node)
        }
    }
}