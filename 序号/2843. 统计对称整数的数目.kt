/** 25/04/15 */
class Solution {
  private lateinit var t:IntArray
  var n = 0
  private fun lowerBit(x:Int) = x and -x
  private fun update(_i:Int){
      var i = _i
      while(i<=n){
          t[i]+=1
          i+=lowerBit(i)
      }
  }
  
  private fun query(_i:Int):Int{
      var i = _i
      var ans = 0
      while(i>0){
          ans+=t[i]
          i-=lowerBit(i)
      }
      return ans
  }
  fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
      n = nums2.size
      t = IntArray(n+1) // 数状数组下标从1开始
      val mp = IntArray(n)
      for(i in 0 until n) mp[nums1[i]]=i // mp存储nums1的值对应的索引
      var ans = 0L
      for(i in 0 until n){
          val x = mp[nums2[i]]
          val lower = query(x)
          val higher = n-1-x - (i-lower) // 总共有多少个更大的，减去前面有多少个更大的，就是后面有多少个更大的
          ans += lower.toLong()*higher
          update(x+1)
      }
      return ans
  }
}

class Solution {
  fun countSymmetricIntegers(low: Int, high: Int): Int {
      val highList = high.toString().map { it - '0' }
      val lowList = low.toString().padStart(highList.size, '0').map { it - '0' }
      val n = highList.size
      val mem = mutableMapOf<Int, Int>()
      fun dfs(i: Int, lowLimit: Boolean, highLimit: Boolean, start: Int, remain: Int): Int {
          if (i == n) {
              return if (remain==0) 1 else 0
          }
          // i 最多到5，start最多到5,remain最多19,占5位
          val key = remain.shl(10).or(i shl 5).or(start)
          if (start!=-1 && !lowLimit && !highLimit && mem.contains(key)) return mem[key]!!
          val lo = if (lowLimit) lowList[i] else 0
          val hi = if (highLimit) highList[i] else 9

          // 判断数字个数为奇数的情况
          if(start<0 && (n-i).and(1)==1){
              if (lo>0) return 0 // 当前位必须有数字，就真是奇数了，否则可以当前为0,继续往后
              return dfs(i+1,true,false,start, remain)
          }

          var ans = 0
          val isLeft = start==-1 || i<(start+n)/2
          for (j in lo..if(isLeft) hi else min(hi,remain)) {
              ans += dfs(i + 1,
                  lowLimit && j == lo,
                  highLimit && j == hi,
                  if(start<0 && j>0) i else start,  // j 作为第1位
                  if (isLeft) remain+j else remain-j // 左边增，右边减
              )
          }
          if (start!=-1 && !lowLimit && !highLimit)
              mem[key] = ans
          return ans
      }
      return dfs(0, true, true, -1,0)
  }
}