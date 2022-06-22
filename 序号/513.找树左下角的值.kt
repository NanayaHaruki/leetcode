class Solution {
  fun findBottomLeftValue(root: TreeNode): Int {
    val q = ArrayDeque<TreeNode>()
    if (root.left != null) q.add(root.left!!)
    if (root.right != null) q.add(root.right!!)
    var ans = root.`val`
    var layerSize = q.size
    while (q.isNotEmpty()) {
      for (i in 0 until layerSize) {
        val f = q.removeFirst()
        if (i == 0) ans = f.`val` // 更新每一层最左边的
        if (f.left != null) q.add(f.left!!)
        if (f.right != null) q.add(f.right!!)
      }
      layerSize = q.size
    }
    return ans
  }
}