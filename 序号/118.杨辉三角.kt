/** 25-08-01 */
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val ans = MutableList(numRows) { MutableList(it+1){0}  }
        for (row in 0 until numRows){
            for (i in 0 .. row){
                if(i==0) ans[row][i]=1
                else if(i==row) ans[row][i]=1
                else{
                    ans[row][i]=ans[row-1][i-1]+ans[row-1][i]
                }
            }
        }
        return ans
    }
}

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        return generate(rowIndex+1)[rowIndex]
    }
    fun generate(numRows: Int): List<List<Int>> {
        // 杨辉三角
        val ans = mutableListOf<List<Int>>()
        ans.add(listOf(1))
        if (numRows == 1) return ans
        // 第i行，但是在ans的索引是i-1
        for (i in 2.. numRows) {
            val row = IntArray(i)
            for (j in 0 until i) {
                if (j == 0 || j == i - 1) row[j] = 1
                // 上一行 要找ans[i-1] 因为i是第几行，而不是真正的索引，所以要再减1
                else row[j] = ans[i - 2][j - 1] + ans[i - 2][j]
            }
            ans.add(row.asList())
        }
        return ans
    }
}