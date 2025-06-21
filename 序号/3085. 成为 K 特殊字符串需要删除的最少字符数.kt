class Solution {
  fun minimumDeletions(word: String, k: Int): Int {
      val cnts = mutableMapOf<Char,Int>()
      for(c in word){
          cnts.merge(c,1,Int::plus)
      }
      val freq = cnts.values.sorted() // 频率绝对值不大于k，一种将高频的删掉一部分，一种将低频全部删掉
      var preSum = 0
      var ans = word.length
      for (l in freq.indices){
          val lmt = freq[l]+k
          // 后面超过r的删掉
          var delCnt = 0
          for (r in l+1 until freq.size){
              if (freq[r]>lmt) delCnt+=freq[r]-lmt
          }
          if(preSum+delCnt<ans) ans = preSum+delCnt
          preSum+=freq[l]
      }

      return ans
  }
}