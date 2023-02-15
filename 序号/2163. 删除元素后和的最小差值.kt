class Solution {
  fun minimumDifference(nums: IntArray): Long {
    // 长度3n，删掉n个数，使前n个数之和 - 后n个数之和最小。需要前n个数尽可能小，后n个数尽可能大
    // 前n个数取值索引为[0,2n-1]， 后n个数取值索引范围为[n,3n-1],分别求出在每个索引上两个堆的和的极值，更新答案
    val a = PriorityQueue<Int>{a,b->b-a} // 默认是小顶堆，前n个集需要弹出最大的
    val b = PriorityQueue<Int>()
    val n = nums.size/3
    val resA = LongArray(3*n)
    val resB = LongArray(3*n)
    var sumA = 0L
    var sumB = 0L
    for(i in 0 until n){
      a.add(nums[i])
      b.add(nums[nums.size-1-i])
      sumA+=nums[i]
      resA[i]=sumA
      sumB+=nums[nums.size-1-i]
      resB[nums.size-1-i]=sumB
    }
    for(i in n until 2*n){
      if(nums[i]<a.peek()!!){
        val top = a.poll()!!
        a.add(nums[i])
        sumA=sumA-top+nums[i]
      }
      resA[i]=sumA
    }
    for(i in 2*n-1 downTo n){
      if(nums[i]>b.peek()!!){
        val top = b.poll()!!
        b.add(nums[i])
        sumB=sumB-top+nums[i]
      }
      resB[i]=sumB
    }
    var ans = Long.MAX_VALUE
    for(i in n-1 until 2*n){
      ans = kotlin.math.min(ans,resA[i]-resB[i+1])
    }
    return ans
  }
}