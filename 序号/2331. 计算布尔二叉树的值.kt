class Solution {
  fun evaluateTree(root: TreeNode?): Boolean {
      if(root?.left==null) return root!!.`val`>0
      return if(root!!.`val`==2){
          evaluateTree(root?.left) or evaluateTree(root?.right)
      }else{
          evaluateTree(root?.left) and evaluateTree(root?.right)
      }
  }
}