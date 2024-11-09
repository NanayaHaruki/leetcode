class NeighborSum(val grid: Array<IntArray>) {
    val d = mutableMapOf<Int, IntArray>()

    init {
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                d[grid[i][j]] = intArrayOf(i, j)
            }
        }
    }

    fun adjacentSum(value: Int): Int {
        val (i, j) = d[value]!!
        return (grid.getOrNull(i - 1)?.getOrNull(j) ?: 0) + (grid.getOrNull(i + 1)?.getOrNull(j)
            ?: 0) + (grid.getOrNull(i)?.getOrNull(j + 1) ?: 0) + (grid.getOrNull(i)?.getOrNull(j - 1) ?: 0)
    }

    fun diagonalSum(value: Int): Int {
        val (i,j) = d[value]!!
        return (grid.getOrNull(i - 1)?.getOrNull(j-1) ?: 0) + (grid.getOrNull(i - 1)?.getOrNull(j+1)
            ?:0) + (grid.getOrNull(i+1)?.getOrNull(j + 1) ?: 0) + (grid.getOrNull(i+1)?.getOrNull(j - 1) ?:0)
    }

}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * var obj = NeighborSum(grid)
 * var param_1 = obj.adjacentSum(value)
 * var param_2 = obj.diagonalSum(value)
 */