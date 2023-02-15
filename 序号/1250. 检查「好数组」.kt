class Solution {
  fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  fun isGoodArray(nums: IntArray): Boolean {
    // 当数组子集存在 a*x1 + b*x2+ ...=1 时，返回true
    // 根据裴蜀定理，就是求nums中是否存在互质子集
    // 裴蜀定理： 
    //      ax+by=gcd(a,b)*n 对整数a,b存在任意整数x,y,ax+by之和为a,b最大公约数的倍数。
    //      ax+by=gcd(a,b) 也一定存在解
    // 推论：a,b互质的充要条件为 ax+by=1存在整数解
    var g = nums[0]
    for(i in 1 until nums.size){
      g = gcd(g,nums[i])
      if(g==1) return true
    }
    return g==1
  }
}