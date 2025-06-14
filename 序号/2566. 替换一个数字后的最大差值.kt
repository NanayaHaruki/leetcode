class Solution {
  fun minMaxDifference(num: Int): Int {
      val cs = num.toString().toCharArray()
      var chr = '#'
      for(i in cs.indices){
          if(cs[i]=='9') continue
          if(chr=='#') chr=cs[i]
          if(cs[i]==chr) cs[i]='9'
      }
      val mx = String(cs).toInt() 

      val cs2 = num.toString().toCharArray()
      chr = cs2[0]
      for(i in cs2.indices){
          if(cs2[i]==chr) cs2[i]='0'
      }
      return String(cs).toInt()-String(cs2).toInt()

      
  }
}