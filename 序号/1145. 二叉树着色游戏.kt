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
class Solution {
  val d = mutableMapOf<Int,Int>()
  var _x =0
  var xl=0
  var xr=0
  fun dfs(node:TreeNode?):Int{
    if(node==null) return 0
    if(d.contains(node.`val`)) return d[node.`val`]!!
    val l = dfs(node.left)
    val r = dfs(node.right)
    if(node.`val`==_x){
      xl=l
      xr=r
    }
    val s = l+r+1
    d[node.`val`]=s
    return s
  }

  fun btreeGameWinningMove(root: TreeNode, n: Int, x: Int): Boolean {
    // 因为节点不重复，先dfs，收集每个节点的子节点数量
    // 如果落子在x的父节点，检查能否胜利，否则检查x的左右子树大小，检查能否胜利
    _x=x
    dfs(root)
     // 判断落子x的父节点，己方获得除x及x子节点以外所有节点
    val sx = d[x]!!
    val total = d[root.`val`]!!
    if(total-sx>sx) return true
    // 选择x的左树
    if(xl>total-xl) return true
    if(xr>total-xr) return true
    return false
  }
}