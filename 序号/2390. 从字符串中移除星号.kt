class Solution {
  fun removeStars(s: String): String {
      val cs = s.toCharArray()
      val st = mutableListOf<Char>()
      for (c in s){
          if(c!='*'){
              st.add(c)
              continue
          }
          if (st.isNotEmpty()) st.removeLast()
      }
      return String(st.toCharArray())
  }
}