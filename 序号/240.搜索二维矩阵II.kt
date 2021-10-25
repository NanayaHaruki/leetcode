fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    // 二维数组找数
    // 先判定在不在这一行，在就二分，不在下一行
    val row = matrix.size
    val col = matrix[0].size
    for (i in 0 until row){
        if (matrix[i].first()<=target && matrix[i].last()>=target){
            // 这一行有希望，二分
            var l = 0
            var r = col-1
            while(l<=r){
                val m = l+(r-l)/2
                if (matrix[i][m]==target){
                    return true
                }else if (matrix[i][m] < target) {
                    l=m+1
                }else if(matrix[i][m]>target){
                    r=m-1
                }
            }
            // 没找着，下一行
        }
    }
    return false
}