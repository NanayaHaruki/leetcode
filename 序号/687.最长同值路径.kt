var max = 0
fun longestUnivaluePath(root: TreeNode?): Int {
  dfs(root)
  return max
}

// 不可通过根节点的最大长度
fun dfs(node:TreeNode?):Int{
  if (node==null) return 0
  var ans = 0;var cur = 0
  val l =  dfs(node.left)
  val r = dfs(node.right)
  if (node.left?.`val`==node.`val`){
    ans=l+1;cur = ans
  }
  if(node.right?.`val`==node.`val`){
    ans= maxOf(ans,r+1);cur+=r+1
  }
  max = maxOf(max,cur)
  return ans
}