fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    //有障碍物，数组中值为1,只能朝下和右走，只要有障碍物，则障碍物当前行右边只能从上方过来
    val row = obstacleGrid.size
    val col = obstacleGrid.first().size
    val dp = Array(row){IntArray(col)}
    var leftColStone = false
    for (i in 0 until row){
        var haveStone = false
        for(j in 0 until col){
            if (obstacleGrid[i][j]==1) {
                haveStone=true
                if (j==0) leftColStone=true
                continue
            }
            if (i==0){
                if (haveStone) dp[i][j]=0
                else dp[i][j] = 1
            }else if(j==0){
                if (leftColStone) dp[i][j]=0
                else dp[i][j]=1
            }else {
                dp[i][j]=dp[i][j-1]+dp[i-1][j]
            }
        }
    }
    return dp[row-1][col-1]
}