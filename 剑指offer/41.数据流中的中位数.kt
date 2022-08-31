class MedianFinder() {
  /** 数列中能返回中位数
   *  用大顶堆存小于中位数的，堆顶为小于中位数中最大的数；小顶堆存大于中位数的，堆顶为大于中位数中最小的数。
   *  总数量为奇数时，大顶堆比小顶堆多一个，中位数为大顶堆的堆顶；
   *  总数为偶数时，中位数为两个堆的堆顶平均数；
   *  每次添加数时，如果两堆数量相等，则判断新加元素与中位数大小，
   *    如果大，往小顶堆添加，将小顶堆堆顶挪入大顶堆
   *    如果小，直接王大顶堆加即可
   *  如果两队数量不等，则判断新加元素与中位数大小，
   *    如果大，放入小顶堆。此时两队数量变成相同了
   *    如果小，放入大顶堆，将大顶堆原先的堆顶元素加入小顶堆
   * */
  val lq = PriorityQueue<Int>{o1,o2-> o2-o1}
  val rq = PriorityQueue<Int>()
  fun addNum(num: Int) {
    if(lq.isEmpty()) {
      lq.add(num)
      return
    }
    val mid = findMedian()
    if(lq.size==rq.size){
      if(num>mid){
        rq.add(num)
        lq.add(rq.poll())
      }else{
        lq.add(num) // 两堆数量相同，数又与中位数相同，优先往左边加
      }
    }else{
      if(num>=mid){ // 左边数量多一些，加进来个中位数，优先往右边加，保持两堆数量相同
        rq.add(num)
      }else{
        lq.add(num)
        rq.add(lq.poll())
      }
    }
  }
  
  fun findMedian(): Double {
    if(lq.size>rq.size) return lq.peek().toDouble()
    return (lq.peek()+rq.peek())/2.0
  }
  
}