package easy.array

/**
 * 有效的数独
 */

//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
//上图是一个部分填充的有效的数独。
//
//数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//示例 1:
//
//输入:
//[
//["5","3",".",".","7",".",".",".","."],
//["6",".",".","1","9","5",".",".","."],
//[".","9","8",".",".",".",".","6","."],
//["8",".",".",".","6",".",".",".","3"],
//["4",".",".","8",".","3",".",".","1"],
//["7",".",".",".","2",".",".",".","6"],
//[".","6",".",".",".",".","2","8","."],
//[".",".",".","4","1","9",".",".","5"],
//[".",".",".",".","8",".",".","7","9"]
//]
//输出: true
//示例 2:
//
//输入:
//[
//["8","3",".",".","7",".",".",".","."],
//["6",".",".","1","9","5",".",".","."],
//[".","9","8",".",".",".",".","6","."],
//["8",".",".",".","6",".",".",".","3"],
//["4",".",".","8",".","3",".",".","1"],
//["7",".",".",".","2",".",".",".","6"],
//[".","6",".",".",".",".","2","8","."],
//[".",".",".","4","1","9",".",".","5"],
//[".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
//说明:
//
//一个有效的数独（部分已被填充）不一定是可解的。
//只需要根据以上规则，验证已经填入的数字是否有效即可。
//给定数独序列只包含数字 1-9 和字符 '.' 。
//给定数独永远是 9x9 形式的。push

fun isValidSudoku(board: Array<CharArray>): Boolean {
    // 不用考虑可解的话，就只判断下小9格重复性 以及横纵的重复性即可
    val POINT = '.'
    for (row in 0..8) {
        for (column in 0..8) {
            val char = board[row][column]
            if (char != POINT) {
                // 判断横轴
                if (board[row].count { it == char } > 1) {
                    return false
                }
                // 判断纵轴
                var columnCount = 0
                for (k in 0..8) {
                    if (board[k][column] == char) {
                        columnCount++
                    }
                }
                if (columnCount > 1) {
                    return false
                }
                // 判断小九宫格
                var smallBoardCount = 0
                // 先定位，只要定位小九宫格的左上角即可定位整个小九宫格
                val startX = when (row) {
                    in 0..2 -> 0
                    in 3..5 -> 3
                    else -> 6
                }
                val startY = when (column) {
                    in 0..2 -> 0
                    in 3..5 -> 3
                    else -> 6
                }
                for (x in startX..startX + 2) {
                    for (y in startY..startY + 2) {
                        if (board[x][y] == char) {
                            smallBoardCount++
                        }
                    }
                }
                if (smallBoardCount > 1) {
                    return false
                }


            }
        }
    }
    return true
}