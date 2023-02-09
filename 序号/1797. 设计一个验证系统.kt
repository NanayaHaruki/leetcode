class AuthenticationManager(timeToLive: Int) {
  val overTime = timeToLive
  val d = mutableMapOf<String,Int>()


  /** 生成token */
  fun generate(tokenId: String, currentTime: Int) {
    d[tokenId]=currentTime
  }

  /** 刷新时间 */
  fun renew(tokenId: String, currentTime: Int) {
    val time = d[tokenId]
    if(time==null)  // 不存在,或已过期，不做操作
      return
    if(time+overTime<=currentTime){
      d.remove(tokenId)
      return
    }
    d[tokenId]=currentTime
  }

  /** 返回在[currentTime]未过期验证码数目 */
  fun countUnexpiredTokens(currentTime: Int): Int {
    var cnt=0
    val s = mutableSetOf<String>()
    for((id,time) in d){
      if(time+overTime>currentTime) cnt++
      else s.add(id)
    }
    for(id in s){
      d.remove(id)
    }
    return cnt
  }
}