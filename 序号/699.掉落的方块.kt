fun fallingSquares(positions: Array<IntArray>): List<Int> {
  // 暴力 枚举所有方块，有重叠则高度叠加
  val heights = MutableList(positions.size){0}
  for (i in positions.indices){
    val l = positions[i][0]; val r = l+positions[i][1]-1; val h = positions[i][1]
    var curH = h
    for (j in 0 until i){
      val preL = positions[j][0]; val preR = preL+positions[j][1]-1; val preH = positions[j][1]
      if (l>preR || r<preL) continue
      curH= maxOf(curH,heights[j]+h)
    }
    heights[i]=curH
  }
  // 此时heights为落下方块后，各个点的最大高度，题目要求落下后的最大高度
  for (i in 1 until positions.size){
    heights[i]= maxOf(heights[i],heights[i-1])
  }
  return heights
}