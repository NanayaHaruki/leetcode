class Solution {
  fun levelOrder(root: Node?): List<List<Int>> {
    // n叉树 层序遍历 bfs
    if (root == null) return emptyList()
    val ans = mutableListOf<MutableList<Int>>()
    var sum = root.children.size
    mutableListOf<Int>().toList()
    ans.add(mutableListOf(root.`val`))
    val q = ArrayDeque<Node>()
    q.addAll(root.children)
    while (q.isNotEmpty()) {
      val tmp = mutableListOf<Int>()
      var nextSum = 0
      for (i in 1..sum) {
        val node = q.poll()
        tmp.add(node.`val`)
        if (node.children.isNotEmpty()) {
          q.addAll(node.children)
          nextSum += node.children.size
        }
      }
      sum = nextSum
      ans.add(tmp)
    }
    return ans
  }
}