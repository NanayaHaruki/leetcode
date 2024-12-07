class Solution {
    val directions = arrayOf(
        -2 to -1,-2 to 1,
        -1 to -2,-1 to 2,
        1 to -2,1 to 2,
        2 to -1,2 to 1
    )
    // n 25,需要5位，k最大100需要7位，r c小于n需要5位
    val mem = mutableMapOf<Int,Double>()
    fun dfs(r:Int,c:Int,k:Int,n:Int):Double{
        if(r<0 || r>=n || c<0 || c>=n){
           return 0.0
        }else{
            if(k==0){ // 没剩余步数了，又在界内
                return 1.0
            }else{ // 还有步数，继续走，8个方向
                var key = r.shl(12).or(c shl 7).or(k)
                if(mem.contains(key)) return mem[key]!!
                var sum = 0.0
                for((dx,dy) in directions){
                    sum += dfs(r+dx,c+dy,k-1,n)
                }
                val v = sum/8
                mem[key]=v
                return v
            }
        }
    }
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        return dfs(row,column,k,n)
    }
}