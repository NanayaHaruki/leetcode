class Solution {
  fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
      // 会议不能重叠，首尾不能相连。 移动会议使相邻会议空间最大，最多移动k次
      // 移动一个会议，让其与另一个会议贴贴，这个会议左右两边的空间就会合并。总共可以移动k个会议，就可以将k+1个空间合并
      // 统计所有空间，滑动窗口看哪个k+1的空间最大
      val n = startTime.size
      val f = IntArray(n+1)
      f[0]=startTime[0]
      f[n]=eventTime-endTime[n-1]
      for (i in 1 until n){
          f[i] = startTime[i]-endTime[i-1]
      }
      var ans = 0
      var cur = 0
      for (i in 0 .. k) cur+=f[i]
      ans = cur
      for (i in k+1 .. n){
          cur = cur - f[i-k-1]+f[i]
          if(cur>ans) ans = cur
      }
      return ans
  }
}