fun asteroidCollision(asteroids: IntArray): IntArray {
  val q = ArrayDeque<Int>()
  for (i in asteroids) {
    if (q.isEmpty() || i > 0) {
      q.addLast(i)
      continue
    }
    
    // 当前行星往左，检查队列中能否撞击
    var curExist = true
    while (q.isNotEmpty()) {
      val last = q.last()
      // 撞击
      if (last > 0) {
        if (last < -i) {
          q.removeLast()
        }else if(last==-i){
          q.removeLast()
          curExist=false
          break
        }else{
          curExist=false
          break
        }
      } else {
        break
      }
    }
    if (curExist) q.addLast(i)
  }
  return q.toIntArray()
}