class Solution {
  // a和b都小于50，各6位就足够存了。i小于2000，用11位存，加起来11+12=23位，一个int够存
  private val mem = mutableMapOf<Int,Int>()
  private lateinit var ns :IntArray
  private val mod :Int = 1e9.toInt()+7
  private fun dfs(lowerA:Int,higherB:Int,i:Int):Int{
    if(i==ns.size) return 1
    if(lowerA<0 || higherB<0) return 0
    val k = lowerA.or(higherB shl 6).or(i shl 12)
    if(mem.contains(k)) return mem[k]!!
    var ans = 0
    for(a in lowerA..ns[i]){
      val b = ns[i]-a
      if(b<=higherB) {
        ans =  (ans + dfs(a, b, i + 1))%mod
      }
    }
    mem[k]=ans
    return ans
  }
  fun countOfPairs(nums: IntArray): Int {
    ns = nums
    return dfs(0,nums[0],0)
  }
}