/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
  fun dfs(h:ListNode?,r:TreeNode?):Boolean{
      if (h==null) return true
      if (r==null) return false
      if (h.`val`!=r.`val`) return false
      return dfs(h.next, r.left) || dfs(h.next, r.right)
  }
  fun isSubPath(h: ListNode?, r: TreeNode?): Boolean {
      if (r==null) return false
      if (r.`val`==h!!.`val`) {
          if (dfs(h,r)) return true
      }
      return isSubPath(h,r.left) or isSubPath(h,r.right)
  }
}