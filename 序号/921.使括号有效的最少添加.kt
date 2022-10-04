/** 可以任意位置补缺位的括号，只要计算差即可 */
fun minAddToMakeValid(s: String): Int {
  var cnt = 0
  var ans = 0
  for(c in s){
    if(c=='(') cnt++
    else if(c==')') {
      cnt--
      if(cnt<0) {
        ans++
        cnt=0
      }
    }
  }
  if(cnt>0) ans+=cnt
  return ans
}