class Solution {
    fun canMakeSquare(grid: Array<CharArray>): Boolean {
        // 黑的算1 白的算0，以纵向2格向右移动，只要加起来不是2，都可以
        val m = grid.size
        val n = grid[0].size
        var pre = -5
        var cur = 0
        fun cvt(i: Int, j: Int): Int {
            return if (grid[i][j] == 'B') 1 else 0
        }
        for (i in 1 until m) {
            pre = cvt(i, 0) + cvt(i - 1, 0)
            for (j in 1 until n) {

                cur = cvt(i, j) + cvt(i - 1, j)
                if (pre + cur != 2) {
                    println("$i $j")
                    return true
                }
                pre = cur

            }
        }
        return false
    }
}