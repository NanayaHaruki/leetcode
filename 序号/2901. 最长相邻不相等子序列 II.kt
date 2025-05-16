class Solution {
  private fun checkHamming(a: String, b: String): Boolean {
      if (a.length != b.length) return false
      var dif = 0
      for (i in a.indices) {
          if (a[i] != b[i]) {
              if (dif == 0) dif = 1
              else return false
          }
      }
      return true
  }

  fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
      // 找一个最长的Words的子序列，索引在groups中不等，且子序列相邻元素长度相等且只有一个位置字符不同
      // 定义 f[i]是以 Word[i]开头的最长子序列 f[i] = f[j]+1 ,j=[i+1,n)
      val n = groups.size
      val f = IntArray(n)
      val from = IntArray(n)
      var mxi = 0
      for (i in n-1 downTo 0){
          for (j in i+1 until n){
              if(f[i]<f[j] && groups[i]!=groups[j] && checkHamming(words[i],words[j])){
                  f[i]=f[j]
                  from[i] = j // 记录i是从j来的，用于还原答案
              }
          }
          f[i]+=1
          if(f[i]>f[mxi]) mxi = i 
      }
      val ans = mutableListOf<String>()
      var i = mxi
      for (j in 0 until f[mxi]){
          ans.add(words[i])
          i = from[i]
      }
      return ans
  }
}