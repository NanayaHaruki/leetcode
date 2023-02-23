class Solution {
  fun partition(head: ListNode?, x: Int): ListNode? {
    // 双指针，快指针找小于x的节点接在慢指针后面，慢指针用于维护小于x的节点，快指针用于遍历
    val fakeHead = ListNode(0).apply { next = head }
    var slow = fakeHead;
    var preFast = fakeHead
    var fast :ListNode?= head
    while(fast!=null && fast.`val`<x){
      fast=fast.next
      slow=slow.next!!
    }
    while (fast!= null) {
      if (fast.`val` < x) {
        val next = fast.next
        fast.next =slow.next
        slow.next = fast
        slow = slow.next!!
        fast=next
        preFast.next = fast
      }else{
        preFast=fast
        fast = fast.next
      }
    }
    return fakeHead.next
  }
}