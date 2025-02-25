class Allocator(val n: Int) {
  private data class Node(val l:Int,var r:Int,var id:Int):Comparable<Node> {
      override fun compareTo(other: Node): Int {
          return l-other.l
      }
  }

  private val tree = TreeSet<Node>()

  fun allocate(size: Int, mID: Int): Int {
      val ite = tree.iterator()
      if (!ite.hasNext()){ // 空的，直接从0分配
          if (size>n) return -1
          tree.add(Node(0,size,mID))
          return 0
      }
      var pre = ite.next()
      if (pre.l-0>=size){ // pre前面有空间
          tree.add(Node(0,size,mID))
          return 0
      }
      while(ite.hasNext()){
          val nxt = ite.next()
          if (nxt.l-pre.r>=size){
              tree.add(Node(pre.r,pre.r+size,mID))
              return pre.r
          }
          pre=nxt
      }
      if(n-pre.r>=size){
          tree.add(Node(pre.r,pre.r+size,mID))
          return pre.r
      }
      return -1
  }

  fun freeMemory(mID: Int): Int {
      val ite = tree.iterator()
      var freeTotal = 0
      while(ite.hasNext()){
          val nxt = ite.next()
          if(nxt.id==mID) {
              freeTotal+=nxt.r-nxt.l
              ite.remove()
          }
      }
      return freeTotal
  }
}

/**
* Your Allocator object will be instantiated and called as such:
* var obj = Allocator(n)
* var param_1 = obj.allocate(size,mID)
* var param_2 = obj.freeMemory(mID)
*/