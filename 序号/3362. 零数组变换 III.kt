class Solution {
  fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
      // 贪心，将q左端点小于nums[i]的入堆，lr的范围在索引内，必定最终全部入堆
      // 从堆中取出右端点最远的（堆中左端点已经满足小于nums[i])了
      // 弹出堆的就是要用的，堆里剩小的就是要删除的
      queries.sortWith{a,b->a[0]-b[0]}
      val pq = PriorityQueue<Int>{a,b->b-a}
      var v = 0
      val n = nums.size
      val nq = queries.size
      val dif = IntArray(n+1)
      var j = 0
      for (i in 0 until n){
          v+=dif[i]
          // 将左端点小的入堆
          while (j<nq && queries[j][0]<=i){
              pq.add(queries[j++][1])
          }
          // 从堆里取右端点最大的
          while(v<nums[i] && pq.isNotEmpty() && pq.peek()>=i){
              dif[pq.poll()+1]-=1
              v+=1
          }
          if(v<nums[i]) return -1
      }
      return pq.size
  }
}