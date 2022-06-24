fun largestValues(root: TreeNode?): List<Int> {
  if(root==null) return emptyList()
  // bfs 找每层最大值
  val q = ArrayDeque<TreeNode>()
  q.add(root!!)
  val ans = mutableListOf<Int>()
  while(q.isNotEmpty()){
    val size = q.size;var max = Int.MIN_VALUE
    for(i in 0 until size){
      val n = q.poll()
      if(n.left!=null) q.add(n.left!!)
      if(n.right!=null) q.add(n.right!!)
      if(n.`val`>max) max = n.`val`
    }
    ans.add(max)
  }
  return ans
}