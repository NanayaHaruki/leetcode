val Q = 'Q'
val E = '.'
lateinit var board: Array<CharArray>
val ans = mutableListOf<List<String>>()
fun solveNQueens(n: Int): List<List<String>> {
    // 在n*n棋盘上Queen，可以横纵斜移动，问能有几种方法
    // 回溯算法 在row,col 放下，判断是否合理（一行行的往下排，横向不用考虑了，只看上方和左右的斜方向即可），不合理 row+1,
    // 放下后，col+1 放下一行，放完了回溯

    // 创建棋盘
    board = Array(n) { CharArray(n) { E } }
    backTrack(0)
    return ans
}

fun isValid(row: Int, col: Int): Boolean {
    // 判断上方
    var r = row - 1
    var c = col
    while (r >= 0) {
        if (board[r][c] == Q) return false
        r--
    }
    // 判断左上
    r = row - 1
    c = col - 1
    while (r >= 0 && c >= 0) {
        if (board[r][c] == Q) return false
        r--
        c--
    }
    // 判断右上
    r = row - 1
    c = col + 1
    while (r >= 0 && c < board.size) {
        if (board[r][c] == Q) return false
        r--
        c++
    }
    return true
}

/** 一次解决一行问题，即Q放在哪一位*/
fun backTrack(row: Int) {
    if (row == board.size) ans.add(board.map { chars -> String(chars) })
    for (col in board.indices) {
        if (isValid(row, col)) {
            board[row][col] = Q
            backTrack(row + 1)
            board[row][col] = E
        }
    }
}