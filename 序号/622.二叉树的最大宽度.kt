//执行用时：172 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
//内存消耗：35.7 MB, 在所有 Kotlin 提交中击败了85.71% 的用户
//通过测试用例：114 / 114
fun widthOfBinaryTree(root: TreeNode?): Int {
  // 每层节点编号i的子树编号为2i和2i+1
  // bfs的同时，再搞个队列记录编号，每层计算一次最大距离
  if(root==null) return 0
  val q = ArrayDeque<TreeNode>()
  q.add(root)
  val idxQ = ArrayDeque<Int>()
  idxQ.add(0)
  var ans = 0
  while(q.isNotEmpty()){
    val size = q.size
    var l = 0 // 当前层最左边的位置
    for (i in 0 until size){
      val idx = idxQ.removeFirst()
      val node = q.removeFirst()
      if (i==0){
        l=idx
      }
      if (node.left!=null){
        q.add(node.left!!)
        idxQ.add(idx*2)
      }
      if(node.right!=null){
        q.add(node.right!!)
        idxQ.add(idx*2+1)
      }
      if(i==size-1){
        ans = maxOf(ans,idx-l+1)
      }
    }
  }
  return ans
}