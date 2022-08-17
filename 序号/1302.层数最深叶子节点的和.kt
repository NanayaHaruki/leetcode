class Solution {
  fun deepestLeavesSum(root: TreeNode?): Int {
    // 最深子节点的和。 bfs不断更新每层和即可
    if(root==null) return 0
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    var ans=0
    while(q.isNotEmpty()){
      var size = q.size
      var curSum=0
      while(size-->0){
        val n = q.removeFirst()
        curSum+=n.`val`
        if(n.left!=null) q.add(n.left)
        if(n.right!=null) q.add(n.right)
      }
      ans=curSum
    }
    return ans
  }
}