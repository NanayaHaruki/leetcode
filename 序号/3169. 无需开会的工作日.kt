/** 128ms */
class Solution {
  fun countDays(days: Int, meetings: Array<IntArray>): Int {
      meetings.sortWith {a,b->a[0]-b[0] }
      val m = mutableListOf<IntArray>()
      for((a,b) in meetings){
          if(a>days) continue
          if(m.isEmpty()){
              m.add(intArrayOf(a,b))
          }else{
              if (a>m.last()[1]){ // 没连上
                  m.add(intArrayOf(a,b))
              }else{ // 连上了，直接更新结束时间
                  if(b>m.last()[1]) {
                      m.last()[1] = b
                  }
              }
          }
      }
      var p = 0
      var ans = 0
      for((a,b) in m){
          ans += a-p-1
          p = b
      }
      if(p<days){
          ans += days-p
      }
      return ans
  }
}

/** 236ms */
class Solution {
  class Kutori(){
      data class Node(val l:Int,val r:Int,val v:Int)
      val t = TreeSet<Node>(){a,b->a.l-b.l}.apply { add(Node(1,Int.MAX_VALUE,0))}
      fun split(x:Int): Node{
          val node = t.floor(Node(x,0,0))!!
          if(node.l==x) return node
          val (l,r,v) = node
          t.remove(node)
          t.add(Node(l,x-1,v))
          val ans = Node(x,r,v)
          t.add(ans)
          return ans
      }

      fun set(l:Int,r:Int){
          val next = split(r+1)
          var cur = split(l)
          while(cur.r<=r){
              t.remove(cur)
              cur= t.higher(cur)!!
          }
          t.add(Node(l,r,1))
      }
      fun query(l:Int,r: Int): Int{
          val next = split(r+1)
          var cur = split(l)
          var ans = 0
          while(cur.r<=r){
              if(cur.v==0) ans += cur.r-cur.l+1
              cur = t.higher(cur)
          }
          return ans
      }
  }
  fun countDays(days: Int, meetings: Array<IntArray>): Int {
      val kutori = Kutori()
      for((a,b) in meetings){
          kutori.set(a,b)
      }
      return kutori.query(1,days)
  }
}