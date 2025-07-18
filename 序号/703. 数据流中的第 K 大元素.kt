class KthLargest(val k: Int, nums: IntArray) {

  // 第k大的数，用个大顶堆，堆大小为k，堆顶就是第k大的数
  private val q = PriorityQueue<Int>()
  init{
      for(x in nums){
          if(q.size<k) q.offer(x)
          else{
              if(x > q.peek()){
                  q.poll()
                  q.offer(x)
              }
          }
      }
  }
  fun add(x: Int): Int {
      if(q.size<k) {
          q.offer(x)
          return q.peek()
      }
      if(x<q.peek()) return q.peek()
      q.poll()
      q.offer(x)
      return q.peek()
  }

}

/**
* Your KthLargest object will be instantiated and called as such:
* var obj = KthLargest(k, nums)
* var param_1 = obj.add(`val`)
*/