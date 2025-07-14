/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
  fun getDecimalValue(head: ListNode?): Int {
      var h = head
      var ans = 0
      while(h!=null){
          ans = ans shl 1
          ans = ans or h.`val`  
          h = h.next
      }
      return ans
  }
}