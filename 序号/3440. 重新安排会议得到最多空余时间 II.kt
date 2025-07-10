class Solution {
  fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
      // 只能移动一个，意味着最多将两个空间合并，如果能挪走，则还要加上会议区间本身的长度
      // 找出所有空间，滑动窗口大小为2（2表示2个空间合并），合并后的长度为备选答案，同时需要判断其他空间中有没有能放的下被挪走的这个区间
      // 可以挪到自己所在的区间（相当于移动到能移到的最左边或最右边）
      val n = startTime.size // n个会议，有n+1个空间，优先挪到自己不在的区间
      val canMove= IntArray(n) 
      var mx = startTime[0]
      for (i in 1 until n){
          if (mx>=endTime[i]-startTime[i]) canMove[i] = canMove[i] or 1
          mx = max(mx,startTime[i]-endTime[i-1])
      }
      mx = eventTime-endTime[n-1]
      for (i in n-2 downTo 0){
          if(mx>=endTime[i]-startTime[i]) canMove[i] = canMove[i] or 1
          mx = max(mx,startTime[i+1]-endTime[i])
      }
      // 知道当前会议能否移走了，能移走，可以空出 前后2个空间+自己会议的空间;不能移走，自己左右移，相当于将左右空间合并
      var ans = 0
      for (i in 0 until n){
          val preEnd = if(i==0) 0 else endTime[i-1]
          val nextStart = if(i==n-1) eventTime else startTime[i+1]
          if(canMove[i]==1){
              ans = max(ans,nextStart-preEnd)
          }else{
              ans = max(ans,nextStart-preEnd-endTime[i]+startTime[i])
          }
      }
      return ans
  }
}