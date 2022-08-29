/** 不考虑大数 */
fun printNumbers(n: Int): IntArray {
  // 返回N位数
  var max = 0
  for(i in 1..n) {
    max = max*10+9
  }
  val ans = IntArray(max)
  for(i in 0 until max) ans[i]=i+1
  return ans
}