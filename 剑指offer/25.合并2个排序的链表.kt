

/*
执行用时：236 ms, 在所有 Kotlin 提交中击败了11.54% 的用户
内存消耗：35.2 MB, 在所有 Kotlin 提交中击败了88.46% 的用户
通过测试用例：218 / 218
*
* */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
  // 合并两个递增链表
  var p1 = l1;var p2 = l2;val dummyHead = ListNode(0);var cur = dummyHead
  while(p1!=null && p2!=null){
    if (p1.`val`<p2.`val`) {
      cur.next=p1
      cur=cur.next!!
      p1=p1.next
    }else{
      cur.next=p2
      cur=cur.next!!
      p2=p2.next
    }
  }
  if (p1==null) cur.next=p2
  else cur.next=p1
  return dummyHead.next
}
/*
*
执行用时：204 ms, 在所有 Kotlin 提交中击败了57.69% 的用户
内存消耗：37.2 MB, 在所有 Kotlin 提交中击败了26.92% 的用户
通过测试用例：218 / 218
* */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
  // 合并两个递增链表
  if (l1 == null) return l2
  if (l2 == null) return l1
  return if (l1.`val` < l2.`val`) {
    // l1 为应该返回的头节点，后面应该接 l1.next 和l2中最小的
    l1.next = mergeTwoLists(l1.next, l2)
    l1
  } else {
    l2.next = mergeTwoLists(l2.next, l1)
    l2
  }
}