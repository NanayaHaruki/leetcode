class Solution {
    fun findBall(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        fun dfs(r:Int,c:Int,h:Int):Int{
            // r,c 是坐标，h为0表示在上半部分，1是下半部分
            if(r==m) return c 
            if(c==0 && grid[r][c]==-1 && h==0) return -1
            if(c==n-1 && grid[r][c]==1 && h==0) return -1 // 卡两边了
            
            if(h==0){
                if(grid[r][c]==1) {
                    if(grid[r][c+1]==-1) return -1
                    else return dfs(r,c+1,1-h)
                }else{
                    if(grid[r][c-1]==1) return -1
                    else return dfs(r,c-1,1-h)
                }
            }else{
                return dfs(r+1,c,0)
            }
        }
        return IntArray(n){dfs(0,it,0)}
    }
}