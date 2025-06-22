class Solution {
  fun divideString(s: String, k: Int, fill: Char): Array<String> {
      val n = s.length
      val ans = Array(n/k+if(n%k==0) 0 else 1){""}
      var i = 0
      while(i+k<n){
          ans[i/k]= s.substring(i,i+k)
          i+=k
      }
      if(i<n){
          ans[i/k]=s.substring(i).padEnd(k,fill)
      }
      return ans
  }
}