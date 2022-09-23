//执行用时：244 ms, 在所有 Kotlin 提交中击败了76.47% 的用户
// 内存消耗：40.5 MB, 在所有 Kotlin 提交中击败了82.35% 的用户
// 通过测试用例：64 / 64
class MyLinkedList() {
  data class Node(val i:Int,var next:Node?,var prev:Node?)
  var head:Node?=null
  var tail:Node?=null
  var size = 0
  private fun getNode(index:Int):Node?{
    if (size==0) return null
    if (index>=size) return null
    var p = head
    if (index<=size/2){
      for (i in 0 until index){
        p=p?.next
      }
      return p
    }else{
      var t =tail
      for (i in 0 until size-1-index){
        t = t?.prev
      }
      return t
    }
  }
  fun get(index: Int): Int {
    val node = getNode(index)?:return -1
    return node.i
  }
  
  fun addAtHead(`val`: Int) {
    val newHead = Node(`val`,null,null)
    if(size==0){
      head=newHead
      tail = head
    }else {
      newHead.next=head
      head?.prev = newHead
      head = newHead
    }
    size++
    
  }
  
  fun addAtTail(`val`: Int) {
    val newTail = Node(`val`,null,null)
    if(size==0){
      tail = newTail
      head = tail
    }else{
      tail?.next = newTail
      newTail.prev=tail
      tail = newTail
    }
    size++
  }
  
  
  fun addAtIndex(index: Int, `val`: Int) {
    if(index>size) return
    if (index<=0) addAtHead(`val`)
    else if(index==size) addAtTail(`val`)
    else{
      val node = getNode(index)
      val prev = node!!.prev
      val newNode=Node(`val`,node,prev)
      node?.prev?.next=newNode
      node?.prev=newNode
      size++
    }
  }
  
  fun deleteAtIndex(index: Int) {
    val node = getNode(index)?:return
    if(size==1){
      head=null
      tail = null
    }else if(node == head){
      head = head!!.next
    }else if(node == tail){
      tail = tail!!.prev
    }else {
      val prev = node.prev
      val next = node.next
      prev?.next = next
      next?.prev = prev
    }
    size--
  }
}