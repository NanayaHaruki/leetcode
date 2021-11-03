fun minFallingPathSum(matrix: Array<IntArray>): Int {
    //这是个正方形，一层层遍历从上到下的和，每个位置的值为上一行左中右三边+自身
    val n = matrix.size
    for (i in 1 until n){
        for (j in 0 until n){
            // 左边界
            if (j == 0) {
                if (j+1<n){
                    matrix[i][j]+=minOf(matrix[i-1][j],matrix[i-1][j+1])
                }else {
                    matrix[i][j]+=matrix[i-1][j]
                }
            }else if(j==n-1){
                if (j-1>=0){
                    matrix[i][j]+=minOf(matrix[i-1][j],matrix[i-1][j-1])
                }else {
                    matrix[i][j]+=matrix[i-1][j]
                }
            }else {
                matrix[i][j]+= minOf(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
            }
        }
    }
    return matrix.last().minOrNull()!!
}