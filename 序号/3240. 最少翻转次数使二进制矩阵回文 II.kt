class Solution {
    fun minFlips(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var ans = 0
        // 对称必然四个点互相对称，计算m*n/4次，找最少修改就行
        for(i in 0 until m/2){
            for(j in 0 until n/2){
                val t = grid[i][j]+grid[m-1-i][j]+grid[i][n-1-j]+grid[m-1-i][n-1-j]
                ans += if(t<=2) t else 4-t
            }
        }
        // 天元若存在必为0，否则不可能是4的倍数
        
        if(m.and(n).and(1) == 1) ans += grid[m/2][n/2]

        // 处理可能存在的中间行和中间列
        var totalOne = 0
        var diff = 0
        if(m.and(1)==1){
            val i = m/2
            for(j in 0 until n/2){
                if(grid[i][j]==grid[i][n-1-j]){
                    totalOne+=grid[i][j]*2
                }else{
                    diff++
                }
            }
        }
        if(n.and(1)==1){
            val j = n/2
            for(i in 0 until m/2){
                if(grid[i][j]==grid[m-1-i][j]){
                    totalOne+=grid[i][j]*2
                }else{
                    diff++
                }
            }
        }
        return if(totalOne%4==0){
            ans+diff // diff 个不同的全部改成0
        }else{
            // totalOne 必为偶数，模4有余数只能是余2
            // 也就是说一样的1，多了2个
            // 只要diff存在，有不一样的，把其中1个改成1就行了
            if(diff>0) ans+diff
            // 没有diff，只能将一样的两个1改成0
            else ans+2
        }
    }
}