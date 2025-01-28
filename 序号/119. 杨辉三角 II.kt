class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        return row[rowIndex]
    }
    companion object{
        const val MAX_LINE = 34
        val row = Array(MAX_LINE){
            MutableList(it+1){1}
        }.apply{
            for(i in 2 until MAX_LINE){
                for(j in 1 until i){
                    this[i][j]=this[i-1][j-1]+this[i-1][j]
                }  
            }
        }
    }
}