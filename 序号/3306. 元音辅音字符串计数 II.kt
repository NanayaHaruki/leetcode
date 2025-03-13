class Solution {
  lateinit var s:String

  var n = 0
  fun check(c:Char):Boolean{
      return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'
  }
  fun count(k:Int):Long{
      // 至少有k个辅音的在子串数量
      var ans = 0L
      var j = 0
      var a = 0 // 元音种类
      var b = 0 // 辅音数量
      val cnts = IntArray(26)
      for (i in 0 .. n-5-k){
          while(j<n && (a<5 || b<k)){
              if (check(s[j])){
                  val amount = cnts[s[j]-'a']++
                  if (amount==0) a++
              }else{
                  b++
              }
              j++
          }
          // 右边界超范围了，或者j-1满足条件了
          if (a==5 && b>=k) ans+=(n-j+1)
          if (check(s[i])){
              val amount = --cnts[s[i]-'a']
              if (amount==0) a--
          }else{
              b--
          }
      }
      return ans
  }
  fun countOfSubstrings(word: String, k: Int): Long {
      // 固定左端点，右端点找到符合k个辅音位置的i，就有n-i个子串满足辅音数量>=k
      // 继续找到 k+1个辅音的位置j，右端点在[j,n)共n-j个子串满足辅音数量>=k+1
      // >=k个辅音的总数 - >=k+1个辅音的总数，就是恰好k个辅音的数量
      s=word
      n=s.length
      return count(k)-count(k+1)
  }
}