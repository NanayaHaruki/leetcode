class ExamRoom(val n: Int) {
  val s = TreeSet<Int>()
  fun seat(): Int {
      if (s.isEmpty()){
          s.add(0)
          return 0
      }
      var cur = 0
      var diff = s.first()
      val it = s.iterator()
      var pre = it.next()
      while(it.hasNext()){
          val nxt = it.next()
          val curDiff = (nxt-pre)/2
          if(curDiff>diff){
              diff = curDiff
              cur = pre+curDiff
          }
          pre=nxt
      }
      if (n-1-s.last()>diff){
          cur = n-1
      }
      s.add(cur)
      return cur
  }

  fun leave(p: Int) {
      s.remove(p)
  }

}