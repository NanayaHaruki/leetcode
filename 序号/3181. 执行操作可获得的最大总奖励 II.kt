class Solution {
  fun maxTotalReward(rewardValues: IntArray): Int {
      val nums = rewardValues.distinct().sorted()
      val n = nums.size
      val mx = nums.max()
      // d[i][j] 前i个数能否拿到j，能拿mx，说明之前没拿到mx，所以最大不可能是mx＊2
      val d = BooleanArray(mx*2)
      d[0]=true
      for(i in 1 .. n){
          val x = nums[i-1]
          for(j in 0 until x){
              if (d[j]) d[x+j]=true
          }
      }
      for(i in mx*2-1 downTo 0){
          if(d[i]) return i
      }
      return 0
  }
}