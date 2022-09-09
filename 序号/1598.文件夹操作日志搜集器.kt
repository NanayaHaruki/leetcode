fun minOperations(logs: Array<String>): Int {
  var n = 0
  out@ for (log in logs){
    when(log){
      "./"->continue@out
      "../"->if(n>0) n-=1
      else->n++
    }
  }
  return n
}