/** 二叉树 先序中序可还原 BST 左树 《 root 《 右树，先序排序得中序 */
class Codec() {
  // Encodes a URL to a shortened URL.
  fun serialize(root: TreeNode?): String {
    fun preorder(root: TreeNode?): List<Int> {
      if (root == null) return emptyList()
      val ans = mutableListOf<Int>(root.`val`)
      ans.addAll(preorder(root.left))
      ans.addAll(preorder(root.right))
      return ans
    }
    return preorder(root).joinToString(",")
  }
  
  // Decodes your encoded data to tree.
  fun deserialize(data: String): TreeNode? {
    if (data.isEmpty()) return null
    val preOrder = data.split(",").map { it.toInt() }
    val inOrder = preOrder.sorted()
    return build(preOrder, inOrder)
  }
  
  fun build(preOrder: List<Int>, inOrder: List<Int>): TreeNode? {
    if (preOrder.isEmpty()) return null
    val node = TreeNode(preOrder[0])
    val rootIndex = inOrder.indexOf(preOrder[0])
    node.left = build(preOrder.subList(1, rootIndex + 1), inOrder.subList(0, rootIndex))
    node.right = build(preOrder.subList(rootIndex + 1, preOrder.size), inOrder.subList(rootIndex + 1, inOrder.size))
    return node
  }
}