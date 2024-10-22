class Solution {
  fun countCompleteDayPairs(hours: IntArray): Int {
      val mods = IntArray(24)
      for(h in hours) mods[h%24]++
      // 模1的和模23的加起来就可以
      // 特殊情况，模0和模12的，n个，组合数量为Cn2=n*(n-1)/2
      var ans = mods[0]*(mods[0]-1)/2+mods[12]*(mods[12]-1)/2
      for(i in 1 ..11){
          ans+=mods[i]*mods[24-i]
      }
      return ans
  }
}