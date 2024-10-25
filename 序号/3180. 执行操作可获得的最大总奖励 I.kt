class Solution {
  fun maxTotalReward(rewardValues: IntArray): Int {
      val d = mutableMapOf<Int,Int>()
      fun dfs(i:Int):Int{
          if(i==0) return rewardValues[0]
          if(d.contains(i)) return d[i]!!
          val ans = if(rewardValues[i]>dfs(i-1))  dfs(i-1)+rewardValues[i]
          else dfs(i-1)
          d[i]=ans
          println("$i $ans")
          return ans
      }
      return dfs(rewardValues.lastIndex)
  }
}