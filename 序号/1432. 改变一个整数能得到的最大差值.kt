class Solution {
  fun maxDiff(num: Int): Int {
      // 第1位非9改9 为最大。 第1位非1改1，是1，非0改0
      val cs = num.toString().toCharArray()
      var tmp = ' '
      for(i in cs.indices){
          if(cs[i]=='9') continue
          if(tmp==' ') tmp = cs[i]
          if(tmp==cs[i]) cs[i]='9'
      }
      val cs2 = num.toString().toCharArray()
      if(cs2[0]!='1') {
          tmp = cs2[0]
          for(i in cs2.indices){
              if(cs2[i]==tmp) cs2[i]='1'
          }
      }else{
          tmp = ' '
          for(i in 1 until cs2.size){
              if(cs2[i]<'2') continue
              if(tmp==' ') tmp = cs2[i]
              if(cs2[i]==tmp) cs2[i]='0'
          }
      }
      return String(cs).toInt()-String(cs2).toInt()
  }
}