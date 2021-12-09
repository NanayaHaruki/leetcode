class Solution {
    fun validTicTacToe(board: Array<String>): Boolean {
        //判断黑白棋盘状态
        // 游戏结束了不能继续 不能存在超过1个游戏获胜条件
        // 白子数量=黑子数量 或黑子数量-1
        // 黑子获胜  黑子数量=白子+1
        // 白子获胜 黑子数量==白子
        // 判断胜利条件，再判断数量
        // 不可以都获胜
        var (xCnt, oCnt) = 0 to 0
        var xWin = false
        var oWin = false
        for (i in board.indices) {
            var x = 0
            var y = 0
            for (j in board[i].indices) {
                val c = board[i][j]
                when (c) {
                    'X' -> {
                        xCnt++
                        x++
                        // 最后一行判断纵向胜利
                        if (i == 2) {
                            if (board[0][j] == 'X' && board[1][j] == 'X') xWin = true
                        }
                    }
                    'O' -> {
                        oCnt++
                        y++
                        if (i == 2) {
                            if (board[0][j] == 'O' && board[1][j] == 'O') oWin = true
                        }
                    }
                    ' ' -> {
                    }
                    else -> return false
                }
            }
            // 一行遍历完，判断横向胜利
            if (x == 3) xWin = true
            if (y == 3) oWin = true
        }
        // 判断斜向胜利
        val center = board[1][1]
        if (center == 'X') {
            if ((board[0][2] == 'X' && board[2][0] == 'X')
                || board[0][0] == 'X' && board[2][2] == 'X'
            ) {
                xWin = true
            }
        }
        if (center == 'O') {
            if ((board[0][2] == 'O' && board[2][0] == 'O')
                || board[0][0] == 'O' && board[2][2] == 'O'
            ) {
                oWin = true
            }
        }
        if (xWin && oWin) return false
        if (xWin && xCnt!=oCnt+1) return false
        if (oWin && xCnt!=oCnt) return false
        if (xCnt != oCnt && xCnt != oCnt + 1) return false
        return true
    }
}