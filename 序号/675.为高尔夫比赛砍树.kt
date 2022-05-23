data class Tree(
  /** 从上个点过来需要多少步 */
  val dist: Int,
  val h: Int, val row: Int, val col: Int
)

fun cutOffTree(forest: List<List<Int>>): Int {
  // 从低到高砍树，0为障碍，返回最小步数，砍不完返回-1
  // 先排序按照高度，将数的坐标记录下来。再寻路找到当前位置到下一位置的最短路径，记录步数
  
  // 根据高度排序
  val trees = PriorityQueue<Tree> { t1, t2 -> t1.h - t2.h }
  for (row in forest.indices) {
    for (col in forest[row].indices) {
      val h = forest[row][col]
      if (h > 1)
        trees.add(Tree(0,forest[row][col], row, col))
    }
  }
  
  // 寻路
  var preTree = Tree(0, 0, 0, 0)
  var ans = 0
  while (trees.isNotEmpty()) {
    val curTree = trees.poll()
    val step = daijkstra(preTree, curTree,forest)
    if (step == -1) {
      ans = -1
      break
    }
    ans += step
    preTree = curTree
  }
  return ans
}

/** 两树最短距离 */
fun daijkstra(start: Tree, end: Tree, forest: List<List<Int>>): Int {
  // dist[x][y] 表示该点到start的最小距离
  val dist = MutableList(forest.size) { MutableList(forest[0].size) { Int.MAX_VALUE } }
  dist[start.row][start.col] = 0
  // 根据距离排序
  val q = PriorityQueue<Tree> { t1, t2 -> t1.dist - t2.dist }
  q.add(start)
  while (q.isNotEmpty()) {
    val cur = q.poll()
    if (cur.row == end.row && cur.col == end.col) return cur.dist
    if (dist[cur.row][cur.col] < cur.dist) continue // 已经找到更短路径了
    val aroundTrees = judge(cur,forest)
    for (nextTree: Tree in aroundTrees) {
      if (nextTree.dist < dist[nextTree.row][nextTree.col]) {
        dist[nextTree.row][nextTree.col] = nextTree.dist
        q.add(nextTree)
      }
    }
  }
  return -1
}

/** 判定该点周围能不能走，返回能走的节点 */
fun judge(tree: Tree, forest: List<List<Int>>): List<Tree> {
  // 判断周围是不是能走
  val row = tree.row
  val col = tree.col
  val dist = tree.dist
  val ans = mutableListOf<Tree>()
  if (col > 0 && forest[row][col - 1] > 0) ans.add(Tree(dist + 1, 0, row, col - 1))
  if (col < forest[0].size - 1 && forest[row][col + 1] > 0) ans.add(Tree(dist + 1, 0, row, col + 1))
  if (row > 0 && forest[row - 1][col] > 0) ans.add(Tree(dist + 1, 0, row - 1, col))
  if (row < forest.size - 1 && forest[row + 1][col] > 0) ans.add(Tree(dist + 1, 0, row + 1, col))
  return ans
}