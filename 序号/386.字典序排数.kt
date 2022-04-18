class Solution {
  private val ans = mutableListOf<Int>()
  fun lexicalOrder(n: Int): List<Int> {
    // 1～n的数字 字典序排序
    // 十叉树 dfs遍历
    for (i in 1..9) {
      if (i <= n) {
        ans.add(i)
        dfs(i, n)
      }
    }
    return ans
  }
  
  private fun dfs(i: Int, n: Int) {
    var j = i * 10
    while (j <= i * 10 + 9) {
      if (j < n) {
        ans.add(j)
        dfs(j, n)
        j++
      } else if (j == n) {
        ans.add(j)
        break
      } else {
        break
      }
    }
  }
}