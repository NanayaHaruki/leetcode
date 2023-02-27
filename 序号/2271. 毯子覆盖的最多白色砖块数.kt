class Solution {
  fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
    // 如果毯子左端在区间中间，右移左端覆盖会减少，右端未知，结果只会不变或变差
    // 左移，左端会增加，右端未知，结果会不变或变好
    // 以每个区间开头，计算长度
    tiles.sortBy { it[0] }
    var l = 0;var r = 0;var mx = 0;var curLen = 0
    val n = tiles.size
    while(l<=r && r<n){
      val start = tiles[l][0]
      val end = start+carpetLen-1
      if (tiles[r][1]<=end){ // 够不到，继续往右找
        curLen+=tiles[r][1]-tiles[r][0]+1
        mx= maxOf(mx,curLen)
        r++
      }else{// 右端超了，判断左端
        if (tiles[r][0]<=end){ // 左端没超
          mx= maxOf(mx,curLen+end-tiles[r][0]+1)
        }
        curLen-=tiles[l][1]-tiles[l][0]+1
        l++
      }
    }
    return mx
  }
}