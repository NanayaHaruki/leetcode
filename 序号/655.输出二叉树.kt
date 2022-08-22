class Solution {
  var maxHeight = 0
  var col = 0
  lateinit var ans:MutableList<MutableList<String>>
  fun printTree(root: TreeNode?): List<List<String>> {
    // 题面即题解
    // 先dfs跑一趟，测出maxHeight，建立二维列表
    // 再跑一趟，将正确的节点放入二维列表正确的位置
    if (root==null) return emptyList()
    maxHeight=dfs(root,0)
    col = (1 shl (maxHeight+1))-1
    ans = mutableListOf<MutableList<String>>()
    for(i in 0..maxHeight){
      ans.add(MutableList(col){""})
    }
    set(root,0,(col-1)/2)
    return ans
  }
  
  fun set(node:TreeNode?,h:Int,c:Int){
    if(node==null) return
    ans[h][c]=node.`val`.toString()
    set(node.left,h+1,c-(1 shl (maxHeight-h-1)))
    set(node.right,h+1,c+(1 shl (maxHeight-h-1)))
    
  }
  
  fun dfs(node:TreeNode?,h:Int):Int{
    if(node==null) return h-1
    return maxOf(dfs(node.left,h+1),dfs(node.right,h+1))
  }
}