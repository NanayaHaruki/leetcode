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

// A*

class Solution {
  var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
  fun cutOffTree(forest: List<List<Int>>): Int {
    val trees: ArrayList<IntArray> = ArrayList()
    val row: Int = forest.size
    val col: Int = forest[0].size
    for (i in 0 until row) {
      for (j in 0 until col) {
        if (forest[i][j] > 1) {
          trees.add(intArrayOf(i, j))
        }
      }
    }
    Collections.sort(trees) { a, b -> forest[a.get(0)][a.get(1)] - forest[b.get(0)][b.get(1)] }
    var cx = 0
    var cy = 0
    var ans = 0
    for (i in 0 until trees.size) {
      val steps = bfs(forest, cx, cy, trees[i][0], trees[i][1])
      if (steps == -1) {
        return -1
      }
      ans += steps
      cx = trees[i][0]
      cy = trees[i][1]
    }
    return ans
  }
  
  fun bfs(forest: List<List<Int>>, sx: Int, sy: Int, tx: Int, ty: Int): Int {
    if (sx == tx && sy == ty) {
      return 0
    }
    val row: Int = forest.size
    val col: Int = forest[0].size
    val costed = Array(row) { IntArray(col) }
    for (i in 0 until row) {
      Arrays.fill(costed[i], Int.MAX_VALUE)
    }
    val pq: PriorityQueue<IntArray> = PriorityQueue<IntArray> { a, b -> a.get(0) - b.get(0) }
    costed[sx][sy] = Math.abs(sx - tx) + Math.abs(sy - ty)
    pq.offer(intArrayOf(costed[sx][sy], 0, sx * col + sy))
    while (!pq.isEmpty()) {
      val arr: IntArray = pq.poll()
      val cost = arr[0]
      val dist = arr[1]
      val loc = arr[2]
      val cx = loc / col
      val cy = loc % col
      if (cx == tx && cy == ty) {
        return dist
      }
      for (i in 0..3) {
        val nx = cx + dirs[i][0]
        val ny = cy + dirs[i][1]
        if (nx >= 0 && nx < row && ny >= 0 && ny < col && forest[nx][ny] > 0) {
          val ncost = dist + 1 + Math.abs(nx - tx) + Math.abs(ny - ty)
          if (ncost < costed[nx][ny]) {
            pq.offer(intArrayOf(ncost, dist + 1, nx * col + ny))
            costed[nx][ny] = ncost
          }
        }
      }
    }
    return -1
  }
}

