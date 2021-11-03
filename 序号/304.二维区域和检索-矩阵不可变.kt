class NumMatrix(matrix: Array<IntArray>) {
    val preSum = Array(matrix.size){IntArray(matrix.first().size)}.apply {
        val row = size
        val col = first().size
        for (i in 0 until row) {
            for (j in 0 until col) {
                this[i][j] = ((this.getOrNull(i - 1)?.getOrNull(j) ?: 0)
                        + (this.getOrNull(i)?.getOrNull(j - 1) ?: 0)
                        - (this.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0)
                        )+matrix[i][j]
            }
        }
    }
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return preSum[row2][col2]-(preSum[row2].getOrNull(col1-1)?:0)-(preSum.getOrNull(row1-1)?.getOrNull(col2)?:0)+(preSum.getOrNull(row1-1)?.getOrNull(col1-1)?:0)
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */