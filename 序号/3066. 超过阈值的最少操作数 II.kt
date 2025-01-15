class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
      val q = PriorityQueue<Long>()
      nums.forEach { q.add(it.toLong()) }
      var ans = 0
      while(q.size>=2 && q.first()<k){
          val a = q.poll()
          val b = q.poll()
          q.offer(min(a,b)*2+max(a,b))
          ++ans
      }
      return ans
  }
}