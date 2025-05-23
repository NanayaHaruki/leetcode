class Solution {
  fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
      // 题目虽然要求只能选择一条边的2个点去异或，但实际上这是棵树，任意两点必然连接
      // 想要异或任意2个点，
      // 比如a-b-c： a-b  b-c  b被异或2次值不变，两端的ac被异或了
      // 比如a-b-c-d,a-b b-c c-d  中间的bc被异或了
      // 按照被异或增量最大的排序，不断异或直到异或2个点让总值变小了为止
      var sm = 0L
//        val q = PriorityQueue<Int> { a, b -> b.xor(k) - b - a.xor(k) + a }
//        for (x in nums) q.add(x)
//        while (true) {
//            val a = q.poll()
//            val b = q.poll()
//            val dif = b.xor(k).toLong() - b + a.xor(k) - a
//            if (dif > 0) {
//                sm += dif
//                q.offer(a.xor(k))
//                q.offer(b.xor(k))
//            } else break
//        }
//        return sm+nums.sumOf{it.toLong()}
      val difList = nums.map { it.xor(k)-it }.sortedDescending()
      for(i in 1 until nums.size step 2){
          val dif= difList[i]+difList[i-1]
          if(dif>0) sm+=dif
          else break
      }
      return sm+nums.sumOf { it.toLong() }
  }
}