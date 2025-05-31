class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val vis = BooleanArray(n*n+1)
        vis[1]=true
        val q = ArrayDeque<Int>()
        q.add(1)
        var step = 0
        while(q.isNotEmpty()){
            val sz = q.size
            for(i in 0 until sz){
                val cur = q.removeFirst()
                if(cur==n*n) return step
                for(nxt in cur+1 .. min(n*n,cur+6)){
                    val r = (nxt-1)/n
                    var c = (nxt-1)%n
                    if(r%2==1) c=n-1-c
                    var realNext = if(board[n-1-r][c]==-1) nxt else board[n-1-r][c]
                    if(!vis[realNext]){
                        vis[realNext]=true
                        q.add(realNext)
                    }
                }
            }
            ++step
        }
        return -1
    }
}