fun diffWaysToCompute(expression: String): List<Int> {
  // 表达式2+1*3，可以任意加括号改变运算优先级，返回所有可能的结果
  // 分治，遇到符号，就将表达式分成left与right两部分进行运算，left与right不断递归即可
  val num = expression.toIntOrNull()
  if (num!=null) return listOf(num) // 表达式就是个数字，直接返回
  val ans = mutableListOf<Int>()
  val ops = charArrayOf('+','-','*')
  for (i in expression.indices){
    val c = expression[i]
    if (c !in ops) continue
    val l = diffWaysToCompute(expression.substring(0,i))
    val r = diffWaysToCompute(expression.substring(i+1))
    when(c){
      '+'->{
        for (j in l){
          for(k in r ){
            ans.add(j+k)
          }
        }
      }
      '-'->{
        for (j in l){
          for(k in r ){
            ans.add(j-k)
          }
        }
      }
      '*'->{
        for (j in l){
          for(k in r ){
            ans.add(j*k)
          }
        }
      }
    }
  }
  return ans
}