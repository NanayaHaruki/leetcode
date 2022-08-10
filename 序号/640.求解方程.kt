class Solution {
  
  fun solveEquation(equation: String): String {
    // 解方程 只有+-=x
    // 等号左边统计x系数，左边数字取相反数。 等号右边的x的系数取相反数，数组不变，计算出ax=b
    var isLeft = true
    var isAdd = true
    var a = 0;var b = 0
    val sb = StringBuilder()
    fun calc(){
      if(sb.isEmpty()) return
      val chars = sb.toString()
      if(chars.last()=='x'){
        val multiX = if(chars.length==1) 1 else chars.substring(0,chars.length-1).toInt()
        if(multiX!=0){ // 0x 无意义，不参与运算。其他的加到x的系数上取
          if (!isLeft) isAdd=!isAdd //等式右边x的系数取反
          if(isAdd) a+=multiX else a-=multiX
        }
      }else{
        val num = chars.toInt()
        if(isLeft) isAdd=!isAdd // 等式左边，数字的符号取反
        if (isAdd) b+=num else b-=num
      }
      sb.clear()
    }
    for (char in equation){
      when(char){
        '='->{
          calc()
          isLeft=false
          isAdd=true // 重置符号，等式右边第一个数如果没有符号，会将左边最后一个符号错误的带过去
        }
        '+'->{
          calc()
          isAdd=true
        }
        '-'->{
          calc()
          isAdd=false
        }
        else->sb.append(char)
      }
    }
    calc()
    // "No solution" 。如果方程有无限解，则返回 “Infinite solutions”
    if(a==0) {
      if(b==0) return "Infinite solutions"  // x没了，等式两边都是0，x无限接
      else return "No solution" // x没了，等式两边不等，无解
    }
    return "x=${b/a}"
  }
}