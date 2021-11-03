fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    // 前缀和就行了，先行计算，（i,j) 记录横坐标0-i 纵坐标0-j 所有数的和
    val preSum = Array(mat.size) { IntArray(mat.first().size) }
    val row = mat.size
    val col = mat.first().size
    for (i in 0 until row) {
        for (j in 0 until col) {
            preSum[i][j] = ((preSum.getOrNull(i - 1)?.getOrNull(j) ?: 0)
                    + (preSum.getOrNull(i)?.getOrNull(j - 1) ?: 0)
                    - (preSum.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0)
                    )+mat[i][j]
        }
    }
    val ans = Array(mat.size) { IntArray(mat.first().size) }
    for (i in 0 until row) {
        for (j in 0 until col) {
            //  A      B
            //     i,j
            //  C      D
            // (i,j)的值就是D-B-C+A ，考虑越界，确定好上下左右边界
            val left = j-k-1
            val right = minOf(j + k, col - 1)
            val top = i-k-1
            val down = minOf(i + k, row - 1)
            ans[i][j] =
                (preSum[down][right]
                        -(preSum.getOrNull(top)?.getOrNull(right)?:0)
                        -(preSum.getOrNull(down)?.getOrNull(left)?:0)
                        +(preSum.getOrNull(top)?.getOrNull(left)?:0)
                        )
        }
    }
    return ans
}