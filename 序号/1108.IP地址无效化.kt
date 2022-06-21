fun defangIPaddr(address: String): String {
  val sb = StringBuilder()
  for(c in address){
    if(c=='.') sb.append("[.]")
    else sb.append(c)
  }
  return sb.toString()
}