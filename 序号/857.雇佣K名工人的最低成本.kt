fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
  // 因为同工同酬，按工作质量分发工资，所以一个人的工作质量占总工作质量比例 等于 他的工资占全部工资的比例
  // 总支付工资为 totalMoney，总工作质量为totalQuality，应该达成 totalMoney*（qualityI/totalQuality)>=wageI
  // totalMoney>= totalQuality*wageI/qualityI ,这意味着选一拨人，他们的工作质量是固定的，所要支付的工资 大于 wageI/qualityI
  // 按照wageI/qualityI为性价比排序，要选k个人，就从第k个人开始计算，计算wage.SIZE-K次需要支付的总金额，即可得出最小支付额度
  var sortIndexArr = List(wage.size) { it }
  sortIndexArr=sortIndexArr.sortedWith(object : Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
      return wage[o1] * quality[o2] - wage[o2] * quality[o1]
    }
  })
  
  var totalQ = 0.0
  val pq = PriorityQueue<Int>(object : Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
      return o2-o1
    }
  }) // pq 默认小顶堆，题设需要最小金钱，金钱与质量成正比线性关系，需要将最大质量移除
  for (i in 0 until k - 1) {
    val q = quality[sortIndexArr[i]]
    totalQ += q
    pq.add(q)
  }
  var ans = Double.MAX_VALUE
  for (i in k - 1 until wage.size) {
    val q = quality[sortIndexArr[i]]
    val w = wage[sortIndexArr[i]]
    totalQ += q
    pq.offer(q)
    ans = minOf(ans,  w.toDouble() / q*totalQ)
    totalQ -= pq.poll()
  }
  return ans
}