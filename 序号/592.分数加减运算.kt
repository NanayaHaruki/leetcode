class Solution{
  
  fun fractionAddition(expression: String): String {
    // 分数计算 -1/2+1/2 = 0/1
    // 计算为整数时，分母为1
    var a = 0;var b = 1;var preA= 0;var preB = 1;
    var isAdd = false
    val ex = if (expression[0]=='-') expression else "+$expression"
    val sb = StringBuilder("1")
    fun calc(){
      preB=b
      b = sb.toString().toInt()
      sb.clear()
      
      val lcm = lcm(b,preB)
      a*=(lcm/b)
      preA*=lcm/preB
      if (isAdd) a=preA+a
      else a=preA-a
      // 约分
      if(a==0) b = 1
      else {
        val gcd = gcd(if (a >= 0) a else -a, lcm)
        a /= gcd;b = lcm / gcd
      }
    }
    
    for (c in ex){
      when(c){
        '+'-> {
          calc()
          isAdd=true
        }
        '-'-> {
          calc()
          isAdd=false
        }
        '/'-> {
          preA=a
          a=sb.toString().toInt()
          sb.clear()
        }
        else->sb.append(c)
      }
    }
    calc()
    return sb.append(a).append('/').append(b).toString()
  }
  
  /** gratest common divisor */
  fun gcd(x:Int,y:Int):Int{
    return if (y>0) gcd(y,x%y)
    else x
  }
  
  /** least common multiple */
  fun lcm(x:Int,y:Int):Int{
    val gcd = gcd(x,y)
    return (x/gcd)*(y/gcd)*gcd
  }
  
}