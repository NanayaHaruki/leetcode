class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) return emptyList()
        val res = mutableListOf<Int>()

        val row = MoveArgs(0, matrix.first().size - 1, 1, 0)
        val col = MoveArgs(0, matrix.size - 1, 0, 0)
        while (row.min <= row.max && col.min <= col.max) {
            val currNum = matrix[col.curr][row.curr]
            res.add(currNum)
            if (row.curr == row.min && row.direct == -1) {
                // 回到左边，向上
                row.direct = 0
                col.direct = -1
                col.max--
            } else if (row.curr == row.max && row.direct == 1) {
                // 到最右边，向下转
                row.direct = 0
                col.direct = 1
                col.min++
            }
            if (col.curr == col.min && col.direct == -1) {
                // 向上到头，向右转
                row.direct = 1
                col.direct = 0
                row.min++
            } else if (col.curr == col.max && col.direct == 1) {
                // 向下到头，向左转
                row.direct = -1
                col.direct = 0
                row.max--
            }
            row.curr += row.direct
            col.curr += col.direct
        }
        return res
    }

    data class MoveArgs(
        var min: Int,
        var max: Int,
        var direct: Int,
        var curr: Int
    )
}
