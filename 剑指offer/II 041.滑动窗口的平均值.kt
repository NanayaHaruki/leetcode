class MovingAverage(size: Int) {
  
  /** Initialize your data structure here. */
  val q = ArrayDeque<Int>()
  val size:Int
  var sum = 0.0
  init {
    this.size=size
  }
  
  fun next(`val`: Int): Double {
    if (q.size<size){
      q.offerLast(`val`)
      sum+=`val`
      return sum/q.size
    }else{
      val first = q.pollFirst()
      sum=sum-first+`val`
      q.offerLast(`val`)
      return sum/q.size
    }
  }
}