class Solution {
  var ans = false
  fun makesquare(matchsticks: IntArray): Boolean {
    // 火柴长度，问能否拼成正方形，每根火柴都要使用一次
    // 先求边长，然后拼成4个边长
    val dict = mutableMapOf<Int,Int>()
    var sum = 0
    for (i in matchsticks){
      sum+=i
      dict[i]=(dict[i]?:0)+1
    }
    if (sum%4!=0) return false
    val len = sum/4
    // 数据分组，每组和为len
    matchsticks.sortDescending() // 倒序排列，先解决大的
    if (matchsticks[0]>len) return false //最大的大于边长就不用考虑了
    val target = IntArray(4){len} // 目标是把4条边降到0，遍历到一个数，就减一个
    backtrack(matchsticks,target,0)
    return ans
  }
  
  fun backtrack(sticks:IntArray,target:IntArray,i:Int){
    if (i==sticks.size && target.sum()==0) {
      ans=true
      return
    }
    // 选择放到哪条边
    for ( j in 0..3){
      if (sticks[i]>target[j]) continue
      target[j]-=sticks[i]
      backtrack(sticks, target, i+1)
      if (ans) return //题目只要求找到一种满足条件即可，没有问满足条件的排法有几种，做过选择后如果满足了立刻返回
      target[j]+=sticks[i]
    }
  }
}