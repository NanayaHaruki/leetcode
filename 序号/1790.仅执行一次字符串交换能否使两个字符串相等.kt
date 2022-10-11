class Solution {
  /** 交换一个字符使相等 */
  fun areAlmostEqual(s1: String, s2: String): Boolean {
    var status = 0 // 0 未交换；1 发现第1个位置不一样；2 发现第2个位置不一样
    // 发现第一个位置不一样时，保存下不一样的字符。 发现第2次字符不同时，检查是否为第一次发现的2个字符
    var a = ' ';var b = ' '
    for ( i in s1.indices){
      val c = s1[i];val d = s2[i]
      if (c==d) continue
      if (status==0){
        status=1
        a=c;b=d;
      }else if(status==1){
        if (a==d && b==c){
          status=2
        }else{
          return false
        }
      }else return false
    }
    return status!=1
  }