/** 数数有多少个链表中的一段连续节点，这段连续节点的值都出现在数组里。 */
fun numComponents(head: ListNode?, nums: IntArray): Int {
  // 只要一个节点出现在了nums中，这个节点开头的连续节点就符合题意。
  // 既然这个节点要以开头出现，则该节点的上一节点就不能出现在nums中
  var p :ListNode?= ListNode(-1).apply { next=head }
  val set = nums.toSet()
  var pre = -1
  var ans = 0
  while(p!=null){
    if (set.contains(p.`val`) && !set.contains(pre)) ans++
    pre=p.`val`
    p=p.next
  }
  return ans
}