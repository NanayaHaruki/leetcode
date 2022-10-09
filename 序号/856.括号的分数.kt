/** ()得1分 ()() 2分  (()) 4分 ，求字符串得分 */
fun scoreOfParentheses(s: String): Int {
  // 遇到左括号就压栈，遇到右括号弹栈，如果里面是空的，得分1。如果不是空的，得分*2
  val q = ArrayDeque<Int>()
  q.add(0)
  for (c in s){
    if (c=='(')
      q.add(0)
    else {
      var peek = q.removeLast()
      if (peek==0) peek+=1 else peek*=2
      q.add(q.removeLast()+peek)
    }
  }
  return q.last()
}