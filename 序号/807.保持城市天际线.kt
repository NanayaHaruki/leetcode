fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    // 从4个方向看grid，最大值不变，求最多增加的高度
    // 遍历一遍，记录每行每列的最大高度，再遍历一遍计算可以增加的高度
    val n = grid.size
    var sum = 0
    // 记录最大值，0-n-1 记录每行最大值  n～ 2n-1 记录每列最大值
    val maxRecord = IntArray(n*2)
    for (i in 0 until n){
        for (j in 0 until n) {
            val k = grid[i][j]
            maxRecord[i]= maxOf(maxRecord[i],k)
            maxRecord[j+n]= maxOf(maxRecord[j+n],k)

        }
    }
    for (i in 0 until n){
        for (j in 0 until n){
            val k = grid[i][j]
            // 取该行改列最大值中的小值
            sum+= (minOf(maxRecord[i],maxRecord[j+n])-k)
        }
    }
    return sum
}