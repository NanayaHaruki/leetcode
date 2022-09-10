class Solution {
  fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    // bst剪枝，让节点再[low,high]
    if(root==null) return null
    if (root.`val`<low)
      return trimBST(root.right,low,high)
    else if(root.`val` > high)
      return trimBST(root.left,low,high)
    else
      return root.apply {
        left = trimBST(root.left,low,high)
        right = trimBST(root.right,low,high)
      }
  }
}