fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
  // 判断是否有相同结构的子树
  // 将dfs的数都序列化，然后对比相同的数是否出现1次以上即可
  dfs(root)
  return ans.toList()
}
val map = mutableMapOf<String,TreeNode>()
val ans = mutableSetOf<TreeNode>()
fun dfs(node:TreeNode?):String{
  if (node==null) return ""
  val serial = "(${node.`val`}#${dfs(node.left)}#${dfs(node.right)})"
  val preNode = map[serial]
  if(preNode==null)
    map[serial] = node // 第一次出现，加进哈希表
  else
    ans.add(node) // 以前出现过，返回以前出现过的那个节点，丢进set里去重
  return serial
}