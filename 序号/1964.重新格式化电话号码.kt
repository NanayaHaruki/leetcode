fun reformatNumber(number: String): String {
  val sb = StringBuilder()
  var c: Char;var cnt = 0
  val n = number.length
  for (i in 0 until n) {
    c = number[i]
    if (c == ' ' || c == '-') continue
    sb.append(c)
    cnt++
    if (cnt==3){
      cnt=0
      sb.append('-')
    }
  }
  return if (sb.last()=='-'){ // 数字数量正好是3的倍数
    sb.deleteCharAt(sb.length-1).toString()
  }else if(sb[sb.length-2]=='-'){ // 倒数第2个是-，说明数字数目%3=1，需要将最后4个数字将3-1分割成2-2
    val a = sb[sb.length-3];val b = sb.last()
    sb.delete(sb.length-3,sb.length).append("-$a$b").toString()
  }else{
    sb.toString()
  }
}