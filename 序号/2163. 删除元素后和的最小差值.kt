class Solution {
  fun minimumDifference(nums: IntArray): Long {
      // 3n个数，删掉n个，求前n个和 - 后n个和 最小，即前n个尽可能小，后n个尽可能大
      // 分隔法，插板子，插在n-1 后面，保证前面至少有n个数，终点在2n-1 后面，保证后面有n个数。
      // 板子在[n-1,2n-1]移动，检查答案，记录下板子插在所有位置上，前n个数的最小值和后半部分的最大值，不存在一个数同时被前后都要了的情况
      val m = nums.size
      val n = m/3
      // 处理前缀
      val sumPre = LongArray(3*n)
      var q = PriorityQueue<Int>{a,b->b-a}// 前缀尽可能的小，默认小顶堆，改成大顶堆用来弹出最大的数
      var sum = 0L
      for(i in 0 until 2*n){
          if(i<n) {
              q.offer(nums[i])
              sum += nums[i]
          }else{
              if(nums[i]<q.peek()){
                  sum = sum + nums[i] - q.poll()
                  q.offer(nums[i])
              }
          }
          sumPre[i]=sum
      }
      // 同样处理后缀
      val sumSuf = LongArray(3*n)
      q = PriorityQueue<Int>() // 后缀尽可能的大，用默认的小顶堆，弹出小的数，换成大的数
      sum = 0
      for(i in 3*n-1 downTo n){
          if(i>=2*n) {
              sum += nums[i]
              q.offer(nums[i])
          }else{
              if(nums[i]>q.peek()){
                  sum = sum +nums[i] - q.poll()
                  q.offer(nums[i])
              }
          }
          sumSuf[i]=sum
      }
      // 遍历插板所有方案
      var ans = Long.MAX_VALUE
      for(i in n-1..2*n-1){ // 插在n-1后面 到 2n-1后面
          ans = min(ans,sumPre[i]-sumSuf[i+1])

      }
      return ans
  }
}


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