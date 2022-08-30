class MinStack() {
  
  /** initialize your data structure here. */
  
  class Node(val x:Int,val min:Int,val next:Node?)
  var head:Node?=null
  
  fun push(x: Int) {
    if(head==null) head = Node(x,x,null)
    else head = Node(x,minOf(x,head!!.min),head)
  }
  
  fun pop() {
    head = head?.next
  }
  
  fun top(): Int {
    return head!!.x
  }
  
  fun min(): Int {
    return head!!.min
  }
}