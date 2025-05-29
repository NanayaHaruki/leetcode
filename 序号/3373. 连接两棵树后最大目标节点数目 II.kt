class Solution {
  fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
      // 计算自己树中边为偶数节点数量，计算树2中每个节点的奇数边节点数量，找最大值
      // 对于树2，到节点0的偶数节点比奇数多，树1连接这些偶数节点后，只有少的奇数节点被算做目标节点 。
      // 无论如何决策，都是多的成为目标节点 。偶数多就连奇数节点让偶数节点成为目标节点

      // 对于树1,同样统计到0的偶数节点和奇数节点，偶数集合中所有点的目标节点都一样
      val n = edges1.size + 1
      val m = edges2.size + 1
      val g1 = Array(n) { mutableListOf<Int>() }
      val g2 = Array(m) { mutableListOf<Int>() }
      for ((u, v) in edges1) {
          g1[u].add(v)
          g1[v].add(u)
      }
      for ((u, v) in edges2) {
          g2[u].add(v)
          g2[v].add(u)
      }
      fun dfs(i: Int, f: Int, g: Array<MutableList<Int>>, curType: Int, cnt: IntArray) {
          // 计算节点数量
          cnt[curType]++
          for (j in g[i]) {
              if (j != f) {
                  dfs(j, i, g, 1 - curType, cnt)
              }
          }
      }

      val cnts2 = IntArray(2)
      dfs(0, -1, g2, 0, cnts2)
      val cnts1 = IntArray(2)
      dfs(0, -1, g1, 0, cnts1)
      val mx = cnts2.max()
      val ans = IntArray(n){mx}
      fun dfs1(i: Int, f: Int, g: Array<MutableList<Int>>, curType: Int) {
          ans[i] += cnts1[curType]
          for (j in g[i]) {
              if (j != f) {
                  dfs1(j, i, g, 1 - curType)
              }
          }
      }
      dfs1(0, -1, g1, 0)
      return ans
  }
}