/** 垂直遍历，每个节点(row,col)的子节点为（row+1,col-1) (row+1,col+1),根节点0，0
 *  返回按列升序，列相同，行低的排前面，行相同的按值升序
 * */
data class Node(val treeNode: TreeNode,val row:Int,val col:Int)
fun verticalTraversal(root: TreeNode?): List<List<Int>> {
  if (root==null) return emptyList()
  val tree = TreeMap<Int,MutableList<Node>>()
  val q = ArrayDeque<Node>()
  q.add(Node(root,0,0))
  while (q.isNotEmpty()){
    val node = q.removeFirst()
    val l = tree.getOrDefault(node.col, mutableListOf())
    l.add(node)
    tree[node.col]=l
    if (node.treeNode.left!=null) q.add(Node(node.treeNode.left!!,node.row+1,node.col-1))
    if (node.treeNode.right!=null) q.add(Node(node.treeNode.right!!,node.row+1,node.col+1))
  }
  val ans = mutableListOf<List<Int>>()
  var it = tree.iterator()
  while (it.hasNext()){
    val (col,nodeList) = it.next()
    nodeList.sortWith(object:Comparator<Node>{
      override fun compare(o1: Node, o2: Node): Int {
        if (o1.row<o2.row) return -1
        else if(o1.row > o2.row) return 1
        else{
          return o1.treeNode.`val` - o2.treeNode.`val`
        }
      }
    })
    
    ans.add(nodeList.map { it.treeNode.`val` })
  }
  return ans
}