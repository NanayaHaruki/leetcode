class Solution {
  val mx = 100
  val divisions = Array(mx+1){ mutableListOf<Int>() }
  init {
     for(i in 1..mx){
         for(j in i..mx step i){
             divisions[j].add(i)
         }
     }
  }
  private fun gcd(a:Int,b:Int):Int{
      return if(b==0) a else gcd(b,a%b,)
  }

  fun countPairs(nums: IntArray, k: Int): Int {
      val n = nums.size
      // 找值相等，索引积能被k整除的数对
      // 当前索引是9,k是12,gcd是3,只要有4为因子都可以，用个map存储已经出现的数和因子，两数之和的方式查找
      val cnts = mutableMapOf<Int,Int>() // 索引和值最大就是100,8位够用了
      var ans =0
      nums.forEachIndexed { i, x ->
          if(i>0 && x==nums[0]) ++ans
          ans+=cnts.getOrDefault(x.shl(8).or(k/gcd(i,k)),0)
          for (d in divisions[i])
              cnts.merge(x.shl(8).or(d),1,Int::plus)
      }
      return ans
  }
}

class Solution {
  fun countPairs(nums: IntArray, k: Int): Int {
      val n = nums.size
      var ans = 0
      for(i in 0 until n-1){
          for(j in i+1 until n){
              if(nums[i]==nums[j] && i*j%k==0) ++ans
          }
      }
      return ans
  }
}