class Solution {
  fun maxLevelSum(root: TreeNode?): Int {
    var maxSum = Int.MIN_VALUE;var maxSumLayer = 0
    var sum = 0;var layer = 1
    val q = ArrayDeque<TreeNode>()
    q.add(root!!)
    while(q.isNotEmpty()){
      var size = q.size
      for(i in 0 until size){
        val node = q.removeFirst()
        sum+=node.`val`
        if(node.left!=null) q.add(node.left)
        if(node.right!=null) q.add(node.right)
      }
      if(sum>maxSum){
        maxSum=sum;maxSumLayer=layer
      }
      layer++;sum=0
    }
    return maxSumLayer
  }
}