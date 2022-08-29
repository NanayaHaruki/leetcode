class Solution {
  fun spiralOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty()) return IntArray(0)
    var direction = 1 // 1 向右 2 向下 4 向左 8 向上
    // 走过的改负数，遇到负数转向
    val len = matrix.size*matrix[0].size
    var top = 0;var bottom = matrix.size;var left = -1;var right = matrix[0].size
    val ans = IntArray(len)
    var row = 0;var col = 0
    for(i in 0 until len){
      ans[i]=matrix[row][col]
      matrix[row][col]=-1
      when(direction){
        1-> {
          if(col==right-1) {
            direction = direction shl 1
            row++
            right--
          }else{
            col++
          }
        }
        2->{
          if(row==bottom-1){
            direction=direction shl 1
            col--
            bottom--
          }else{
            row++
          }
        }
        4->{
          if(col==left+1){
            direction = direction shl 1
            row--
            left++
          }else{
            col--
          }
        }
        else->{
          if(row==top+1){
            direction=1
            col++
            top++
          }else{
            row--
          }
        }
      }
    }
    return ans
  }
}