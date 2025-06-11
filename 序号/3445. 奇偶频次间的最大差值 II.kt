class Solution {
  fun calc(arr:List<Int>,a:Int,b: Int,k: Int):Int{
      val inf = Int.MAX_VALUE/2
      var curA = 0
      var curB = 0
      var preA = 0
      var preB = 0
      var l = 0
      var ans = -inf
      // 根据curA的奇偶性 要找preA的奇偶性. 第1维表示a 第2维表示b min[0][0] 表示a偶b偶
      val min = Array(2){ IntArray(2){inf} }
      arr.forEachIndexed { r,x->
          if(x==a) curA++
          else if(x==b) curB++
          while (r-l+1>=k && curA-preA>0 && curB-preB>0){
              val oddEvenA = preA and 1
              val oddEvenB = preB and 1
              min[oddEvenA][oddEvenB] = min(min[oddEvenA][oddEvenB],preA-preB)
              if(arr[l]==a)  preA++
              else if(arr[l]==b) preB++
              l++
          }
          if(r+1>=k)
              ans = max(ans,curA-curB - min[curA.and(1).xor(1)][curB.and(1)])
      }
      return ans
  }
  fun maxDifference(s: String, k: Int): Int {
      // 长度>=k的s的 子串，使其中出现奇数次字符a - 偶数次字符b 的值最大
      // 前缀和统计出现ab的次数，a要出现奇数，如果sum[i]为奇数，那么要找到sum[j]为偶数才可以，两两组合总共4种情况，统计前缀和的同时，记录min的4种情况
      // a 在子串出现次数为 sum[i][a]-sum[j][a] ，b 为 sum[i][b]-sum[j][b]
      // a-b=sum[i][a]-sum[i][b] - (sum[j][a]-sum[j][b]) 只要维护sum[.][a]-sum[.][b] 的最小值即可
      val arr = s.map { it-'0' }
      var ans = Int.MIN_VALUE
      for(i in 0..4){
          for(j in 0..4){
              if(i==j) continue
              ans = max(ans,calc(arr,i,j,k))
          }
      }
      return ans
  }
}