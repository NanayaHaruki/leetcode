//执行用时：952 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
//内存消耗：78 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
//通过测试用例：75 / 75
class Solution {
  /** 将一个0变成1，使岛屿面积最大
   *
  n == grid.length
  n == grid[i].length
  1 <= n <= 500
  grid[i][j] 为 0 或 1
   */
  fun largestIsland(grid: Array<IntArray>): Int {
    // union find,将岛屿连接起来。每个岛用一个根节点表示，用size[ROOT]查询岛大小，选最大的即可
    // 允许变更一个点，遍历点为0的，朝4个方向检查能连接的岛屿，将面积求和即可
    val n = grid.size
    // 初始化并查集，每个点的父亲都是自己，每个点的面积都是1
    for (i in 0 until n*n){
      p[i]=i
      sz[i]=1
    }
    var ans = 0
    // 连通岛屿
    for (i in 0 until n){
      for (j in 0 until n){
        if (grid[i][j]==0) continue
        // 当前是1，向四周扩散找1，进行连通
        for ((diffX,diffY) in dirs){
          val x = i+diffX;val y = j+diffY
          if (x<0 || y<0 || x==n || y==n || grid[x][y]==0) continue
          union(transXY(i,j,n),transXY(x,y,n))
        }
      }
    }
    // 变更一个点，查看是否能将不同岛屿连起来
    for (i in 0 until n){
      for (j in 0 until n){
        if(grid[i][j]==1){
          ans = maxOf(ans,sz[find(transXY(i,j,n))])
        }else{
          var curSize = 1 // 当前这个为0的点变成了1
          val islands = mutableSetOf<Int>()
          for ((diffX,diffY) in dirs){
            val x = i+diffX;val y = j+diffY
            if (x<0 || y<0 || x==n || y==n || grid[x][y]==0) continue
            // 往某个方向有岛屿，root为根节点,因为不同方向的岛屿可能是连通的，他们的根节点为同一个，为了避免重复计算面积，需要set去重
            val root = find(transXY(x,y,n))
            if(islands.add(root)) { // 添加成功了，面积增加；添加失败，说明加过了，直接跳过
              curSize += sz[root]
            }
          }
          ans = maxOf(ans, curSize)
        }
      }
    }
    return ans
  }
  
  // 将行列转换成并查集中的索引
  fun transXY(row:Int,col:Int,n:Int):Int{
    return row*n+col
  }
  
  val p = IntArray(250000)
  val sz = IntArray(250000)
  val dirs = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1))
  fun union(a:Int,b:Int){
    val pa = find(a);val pb =find(b)
    if (pa==pb) return
    if (sz[pa] > sz[pb]) {
      // b树比较小，搬家到a树上去
      sz[pa]+=sz[pb]
      p[pb]=pa
    }else{
      sz[pb]+=sz[pa]
      p[pa]=pb
    }
  }
  
  fun find(x:Int):Int{
    if (p[x]!=x){
      p[x]=find(p[x])
    }
    return p[x]
  }
}