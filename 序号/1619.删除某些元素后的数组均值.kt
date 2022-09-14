/** 删除最小最大的5%，每20个删1个最小的和1个最大的，求其他平均值 */
fun trimMean(arr: IntArray): Double {
  val maxQ = PriorityQueue<Int>() // 小顶堆，用来存大数，不断将小的替换掉
  val minQ = PriorityQueue<Int>(object:Comparator<Int>{ // 大顶堆，用来存小数，不断将堆顶的大数替换掉
    override fun compare(o1: Int, o2: Int): Int {
      return o2-o1
    }
  })
  val n = arr.size; val delN = n/20;var sum = 0
  for (i in arr){
    sum+=i
    if (maxQ.size<delN){
      minQ.add(i); maxQ.add(i);
    }else{
      // 判断是否替换两个堆
      if (minQ.peek()>i){
        minQ.poll()
        minQ.add(i)
      }
      if(maxQ.peek()<i){
        maxQ.poll();maxQ.add(i)
      }
    }
  }
  for (i in 0 until delN){
    sum-=maxQ.poll()
    sum-=minQ.poll()
  }
  return sum.toDouble()/(n-delN*2)
}