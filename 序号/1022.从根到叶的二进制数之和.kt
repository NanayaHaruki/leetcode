var ans = 0
fun sumRootToLeaf(root: TreeNode?): Int {
  if (root == null) return 0
  if (root.left == null && root.right == null) return root.`val`
  if (root.left != null) dfs(root.`val`, root.left!!)
  if (root.right != null) dfs(root.`val`, root.right!!)
  return ans
}

fun dfs(i: Int, root: TreeNode) {
  val j = i shl 1 or root.`val`
  if (root.left == null && root.right == null) {
    ans += j
    return
  }
  if (root.left != null) dfs(j, root.left!!)
  if (root.right != null) dfs(j, root.right!!)
}