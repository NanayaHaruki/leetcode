class RangeModule() {
  
  class ODT{
    data class Node(val l:Int,val r:Int,val v:Int):Comparable<Node>{
      fun minus(node:Node)=l-node.l
      override fun compareTo(other: Node): Int {
        return l-other.l
      }
    }
    private val set = TreeSet<Node>().apply { add(Node(1,1e9.toInt(),0)) }
    
    /** 打断成 [...pos-1] [pos ...] */
    fun split(pos:Int){
      val node = set.floor(Node(pos,0,0))
      if (node.l==pos) return // 如果有这个起点的，不用再打断了
      val lowerNode = set.lower(Node(pos,0,0))
      if (lowerNode!=null) {
        val (l,r,v) = intArrayOf(lowerNode.l,lowerNode.r,lowerNode.v)
        set.remove(lowerNode)
        set.add(Node(l,pos-1,v))
        set.add(Node(pos,r,v))
      }
    }
    
    fun  assign(l:Int,r:Int,v:Int){
      split(r+1);split(l)
      // 删除l-r的节点
      val leftLimit = Node(l,0,0)
      var floor:Node?=set.floor(leftLimit)
      while(floor!=null && floor.l<=r){
        set.remove(floor)
        floor = set.higher(leftLimit) // 前面打断过，这里最后一次必定是floor.l=r+1
      }
      set.add(Node(l,r,v))
    }
    
    fun check(l:Int,r:Int):Boolean{
      var leftLimit = set.floor(Node(l,0,0))
      while(leftLimit.l<=r){
        if(leftLimit.v==0) return false
        leftLimit = set.floor(Node(leftLimit.r+1,0,0))
      }
      return true
    }
  }
  val tree = ODT()
  fun addRange(left: Int, right: Int) {
    tree.assign(left,right-1,1)
  }
  
  fun queryRange(left: Int, right: Int): Boolean {
    return tree.check(left,right-1)
  }
  
  fun removeRange(left: Int, right: Int) {
    tree.assign(left,right-1,0)
  }
  
}