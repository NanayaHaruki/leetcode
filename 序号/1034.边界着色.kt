import java.lang.Math.abs
class Solution {
    private lateinit var grid: Array<IntArray>
    private var originColor = 0
    private var rowMax = 0
    private var colMax = 0
    fun colorBorder(_grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
        // grid的value是颜色，将row col点所在的连通区域的边界的值改为color
        // grid中颜色的取值范围是1～1000，从row col点出发，向四周8个方向扩散，
        // 如果是边界，改成0,如果不是边界改成-1,这样即可以标记边界，又可以标记是否检测过
        // 遍历结束后，要么弄个集合存储边界点赋值，要么遍历grid，将0替换成color。在遍历过程中替换可能会改变边界范围
        grid = _grid
        rowMax = grid.size - 1
        colMax = grid[0].size - 1
        originColor = grid[row][col]
        dfs(row, col)
        for (rowArray in grid) {
            for (j in rowArray.indices) {
                if (rowArray[j] == 0) rowArray[j] = color
                else if (rowArray[j] < 0) rowArray[j] = -rowArray[j]
            }
        }
        return grid
    }

    val directions = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))

    /** 每个点都向4个方向扩散 */
    fun dfs(row: Int, col: Int) {
        if (row < 0 || row > rowMax || col < 0 || col > colMax) return
        if (abs(grid[row][col]) != originColor) return //颜色不同直接返回

        for (directArr in directions) {
            val x = row + directArr[0]
            val y = col + directArr[1]
            val color = grid.getOrNull(x)?.getOrNull(y)
            if (color == null) {
                grid[row][col] = 0 // 越界了,必定为边界
                continue
            }
            if (color <= 0) continue // 检查过了
            if (color != originColor) {
                grid[row][col] = 0 // 在某个方向上不同色，也是边界
                continue
            }
            grid[x][y] = -grid[x][y]
            dfs(x, y) // 同色，继续找边界

        }
    }
}