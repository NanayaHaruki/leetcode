fun checkOnesSegment(s: String): Boolean {
  // 不含前导0，第1位就是1，往后连续的1为第一段。后面再出现1就是false
  var findZero = false
  for(c in s){
    if(c=='1'){
      if(findZero) return false
      else continue // 没找到0，这个1是从第一个1连过来的
    }else{
      if(!findZero) findZero=true
    }
  }
  return true
}