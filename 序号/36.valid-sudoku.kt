/* 暴力
fun isValidSudoku(board: Array<CharArray>): Boolean {
    // 验证有效数独
    // 暴力 每个数，横纵，小9宫各找一遍，不用开辟新空间，但时间最长
    val range = 0..8

    for (i in range) {
        for (j in range) {
            if (board[i][j]=='.') continue
            // 检查横向
            for (k in range) {
                if (k != j && board[i][j]==board[i][k]) {
                    return false
                }
            }
            // 检查纵向
            for (k in range){
                if (k!=i && board[i][j]==board[k][j]) {
                    return false
                }
            }
            // 检查小九宫
            // 第一个数坐标为 i/3*3 j/3*3
            val firstCol = i/3*3
            val firstRow = j/3*3
            for (col in firstCol..firstCol+2) {
                for (row in firstRow..firstRow+2){
                    if (col != i && row != j && board[i][j] == board[col][row]) {
                        return false
                    }
                }
            }

        }
    }
    return true
}
*/

/* hash */
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowSetList = Array(9){ mutableSetOf<Int>()}
    val colSetList = Array(9){ mutableSetOf<Int>()}
    val areaSetList = Array(9){ mutableSetOf<Int>()}
    val r = 0..8
    for (i in r){
        for (j in r){
            val char = board[i][j]
            if (char == '.') continue
            val num = char-'0'
            val area = i/3*3+j/3
            if (rowSetList[i].contains(num)
                || colSetList[j].contains(num)
                || areaSetList[area].contains(num))
                return false
            rowSetList[i].add(num)
            colSetList[j].add(num)
            areaSetList[area].add(num)
        }
    }
    return true
}