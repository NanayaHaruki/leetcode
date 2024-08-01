class Solution {
  fun maxmiumScore(cards: IntArray, cnt: Int): Int {
      cards.sort()
      val n = cards.size
      var j = n-cnt
      var s = 0
      for (i in j until n) s+=cards[i]
      if(s and 1==0) return s
      // 最大的cnt个数之和 是奇数
      // 选中的数中找个最小的奇数，用没选中的数中最大的偶数替换
      // 选中的数中找个最小的偶数，用没选中的数中最大的奇数替换
      var selectMinOdd=0
      var selectMinEven=0
      for (i in j until n){
          val x = cards[i]
          if (x and 1 == 1 && selectMinOdd==0){
              selectMinOdd=x
          }else if(x and 1 == 0 && selectMinEven==0){
              selectMinEven=x
          }
          if (selectMinEven!=0 && selectMinOdd!=0)break
      }
      // 有可能一个奇数都找不到
      var ans =0
      if(selectMinOdd!=0){
          // 找偶数
          for (i in j-1 downTo 0){
              if(cards[i] and 1 == 0){
                  ans = s-selectMinOdd+cards[i]
                  break
              }
          }
      }
      if (selectMinEven!=0){
          // 找奇数
          for(i in j-1 downTo 0){
              if (cards[i] and 1 ==1){
                  ans = max(ans,s-selectMinEven+cards[i])
              }
          }
      }
      return ans
  }
}