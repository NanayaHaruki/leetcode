class Solution {
  fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
      val pq =
          PriorityQueue<IntArray>() { a, b -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] }
      nums.forEachIndexed { index, i -> pq.offer(intArrayOf(i, index)) }
      for (i in 0 until k) {
          val arr = pq.poll()!!
          arr[0] *= multiplier
          pq.offer(arr)
          nums[arr[1]]=arr[0]
      }
      return nums
  }
}