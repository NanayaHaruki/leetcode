class Solution {
  fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
      // cnt % modulo == k,cnt = x * modulo + k
      // 前缀和统计 nums[i] % modulo == k 的元素个数
      // 枚举右维护左
      val n = nums.size
      val ps = IntArray(n+1)
      nums.forEachIndexed{i,x->
          ps[i+1]=ps[i]+ if(x%modulo==k) 1 else 0
      }
      // 找符合的[l,r] ps[r+1]-ps[l] % modulo == k ，k属于[0,modulo)
      // => ps[r+1]-ps[l] % modulo == k % modulo
      // => ps[r+1]-k % modulo = ps[l] % modulo
      // 在枚举r的时候算出的结果，用两数之和的方式寻找之前有多少也是这个结果的l可以满足
      val cnts = IntArray(min(modulo,n+1))
      var ans = 0L
      for (x in ps) {
          if(x>=k) {
              val key = (x - k) % modulo
              ans += cnts[key]
          }
          cnts[x%modulo]++
      }
      return ans
  }
}