
class Solution {
  fun makeFancyString(s: String): String {
      // 不能连续3个一样的，要求删除最少，那连续相同字符最多添加2个
      var cnt  = 0
      var c = '0'
      val sb = StringBuilder()
      for(x in s){
          if(x==c) ++cnt
          else {
              if(cnt==1)
                  sb.append(c)
              else if(cnt>=2) 
                  sb.append(c).append(c)
              
              cnt=1
              c=x
          }
      }
      if(cnt==1) sb.append(c)
      else sb.append(c).append(c)
      return sb.toString()
  }
}