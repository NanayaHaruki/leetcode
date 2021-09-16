class Solution() {
    private lateinit var _board: Array<CharArray>
    private var rowMax = 0
    private var colMax = 0
    private lateinit var _words :MutableSet<String>
    private lateinit var visit :Array<BooleanArray>
    private val ans = mutableListOf<String>()
    private val steps = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1))
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        // word长度不超过10,遍历board每个节点，然后往四个方向搜，超过10返回，路途中有word则添加答案，避免重复搜单词，搜到后移除
        _board = board
        _words=words.toMutableSet()
        rowMax = board[0].size
        colMax = board.size
        visit = Array(colMax){ BooleanArray(rowMax) }

        val sb = StringBuilder()
        for (i in 0 until colMax){
            for (j in 0 until rowMax) {
                sb.append(_board[i][j])
                visit[i][j]=true
                backtrack(i,j,sb)
                visit[i][j]=false
                sb.deleteCharAt(sb.lastIndex)
            }
        }
        return ans
    }

    fun backtrack(col:Int,row:Int,sb:StringBuilder) {
        // 截止条件
        if (sb.length>10) return
        val str = sb.toString()
        if (_words.contains(str)) {
            ans.add(str)
            _words.remove(str)
        }
        // 做选择
        for ((i, j) in steps) {
            val newCol = col+i
            val newRow = row+j
            if (newCol<0||newCol>=colMax || newRow<0||newRow>=rowMax || visit[newCol][newRow])
                continue

            sb.append(_board[newCol][newRow])
            visit[newCol][newRow]=true
            backtrack(newCol,newRow,sb)
            visit[newCol][newRow]=false
            sb.deleteCharAt(sb.lastIndex)
        }
    }
}