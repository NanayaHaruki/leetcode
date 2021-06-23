class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        // 将s按规则放入二维数组，然后遍历数组得出答案
        // 奇数列能放的字符为numRows，偶数列能放的字符数为numRows-2，
        // 为方便计算，建立二维数组的宽度为偶数
        val groupCharCount = numRows + numRows - 2 // 一列一斜 能存的编码
        val group = s.length / groupCharCount + 1 //总共几组
        val groupColCount = 1 + numRows - 2 // 每组多少列  1为竖着的一列，numRows-2 为斜着走的列数
        val col = group * groupColCount
        val arr = Array(numRows) { CharArray(col) }

        // 按提议规则往数组里面塞字符
        var down = true // 从上往下的，col不变，从下往上，col递增
        var currRow = 0
        var currCol = 0
        for (char in s) {
            arr[currRow][currCol] = char
            when (currRow) {
                0 -> {
                    down = true
                    currRow++
                }
                arr.size - 1 -> {
                    down = false
                    currRow--
                }
                else -> {
                    if (down) currRow++
                    else currRow--
                }
            }
            if (!down) {
                currCol++
            }

        }

        // 遍历，生成答案
        val sb = StringBuilder()
        val defaultChar = '\u0000'
        for (charArr in arr) {
            for (char in charArr) {
                if (char != defaultChar) sb.append(char)
            }
        }
        return sb.toString()
    }
}