const val DRAW = 0
const val MOUSE_WIN = 1
const val CAT_WIN = 2
class Solution {

    lateinit var dp:Array<Array<IntArray>>
    lateinit var graph: Array<IntArray>
    fun catMouseGame(_graph: Array<IntArray>): Int {
        // graph[0] 表示 在0的位置可以移动的下一个位置数组
        // 结果：mouse到0 mouse win
        // mouse==cat  cat win
        // turn>=2n draw
        // sp: cat不能到0
        val n = _graph.size
        // dp[i][j][k] 定义为 第i回和，mouse在j处，cat在k处，结果为啥
        graph=_graph
        dp = Array(2*n){Array(n){IntArray(n){-1} } }
        dfs(0,1,2)
        return dp[0][1][2]
    }
    private fun dfs(turn:Int,mouse:Int,cat:Int):Int{
        // 特殊情况
        if (turn>=dp.size)return DRAW
        if (mouse==0)  return MOUSE_WIN.apply {  dp[turn][mouse][cat]= this }
        if (cat == mouse) return CAT_WIN.apply {  dp[turn][mouse][cat]= this }
        // 未初始化
        if (dp[turn][mouse][cat]<0){
            if (turn%2==0){
                // 轮到老鼠动
                var draw = false
                for (next in graph[mouse]){
                    when(dfs(turn+1,next,cat)){
                        MOUSE_WIN-> {
                            return MOUSE_WIN.apply { dp[turn][mouse][cat]= this }
                        }
                        DRAW->  draw = true
                    }
                }
                // 赢了直接返回了，走到这 要么平，要么输
                return if (draw) DRAW.apply { dp[turn][mouse][cat]=this }
                else CAT_WIN.apply { dp[turn][mouse][cat]=this  }
            }else {
                // 轮到猫动
                var draw = false
                for (next in graph[cat]){
                    if (next == 0) continue // 猫不能进洞
                    when(dfs(turn+1,mouse,next)){
                        CAT_WIN-> {
                            return CAT_WIN.apply { dp[turn][mouse][cat]= this }
                        }
                        DRAW->  draw = true
                    }
                }
                // 赢了直接返回了，走到这 要么平，要么输
                return if (draw) DRAW.apply { dp[turn][mouse][cat]=this }
                else MOUSE_WIN.apply { dp[turn][mouse][cat]=this  }
            }
        }
        // 已经算过的直接返回
        return dp[turn][mouse][cat]
    }
}