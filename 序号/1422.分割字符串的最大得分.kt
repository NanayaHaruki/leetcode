class Solution {
  fun maxScore(s: String): Int {
    val n = s.length
    var n0 = 0
    for (i in s){
      if(i=='0') n0++
    }
    var max=0
    var n00 = 0
    // [0,i]为左串，[i+1,n)为右串
    for (i in 0 ..n-2){
      if (s[i]=='0') n00++
      max=maxOf(max,n00+n-1-i-n0+n00) // n00为左串0的数量，n-1-i是右串总长度 n0-n00是右串0的数量
    }
    return max
  }
}