class Solution {
  fun countPrefixes(words: Array<String>, s: String): Int {
      return words.count{s.startWith(w)}

      // val m = s.length
      // var ans = 0
      // for(w in words){
      //     val n = w.length
      //     if(n>m) continue
      //     var ok = true
      //     for(i in 0 until n){
      //         if(w[i]==s[i]) continue
      //         ok=false
      //         break
      //     }
      //     if(ok) ++ans
      // }
      // return ans
  }
}