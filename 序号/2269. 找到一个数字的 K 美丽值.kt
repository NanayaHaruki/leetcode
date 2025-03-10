class Solution {
  fun divisorSubstrings(num: Int, k: Int): Int {
      val s = num.toString()
      var cnt = 0
      for(i in k .. s.length){
          val x = s.substring(i-k,i).toInt()
          if (x==0) continue
          if(num%x==0) ++cnt
      }
      return cnt
  }
}