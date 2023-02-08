class Solution {
  class Node(val dirName: String, var children: MutableMap<String, Node>?, var del: Boolean)

  fun dfs(node: Node?, ans: MutableList<String>) {
    if (node == null) return
    if (node.children == null) {
      ans.add(node.dirName)
      return
    }
    for ((_, v) in node.children!!) {
      dfs(v, ans)
    }

  }

  fun removeSubfolders(folder: Array<String>): List<String> {
    val sb = StringBuilder()
    val root = Node("", mutableMapOf(), false)
    var p :Node
    for (path in folder) {
      val n = path.length
      sb.clear()
      sb.append('/')
      p=root
      for (i in 1 until n) {
        if (i == n - 1) {
          sb.append(path[i])
          val subPath = sb.toString()
          if (p.children != null && p.children!!.contains(subPath)) { // 曾经存过子路径，删掉
            p.children!![subPath]!!.apply {
              this.children = null
              this.del = true
            }
          } else {
            p.children!![subPath] = Node(subPath, null, true)
          }
          break
        }
        if (path[i] == '/') {
          val subPath = sb.toString()
          if (p.children != null && p.children!!.contains(subPath)) {
            if (p.children!![subPath]!!.del) { // 以前存过subPath，现在出现subPath/xxx，反正要删了，直接break不存了
              break
            }
          } else {
            if (p.children == null) {
              p.children = mutableMapOf()
            }
            p.children!![subPath] = Node(subPath, mutableMapOf(), false)
          }
          p = p.children!![subPath]!!
        }
        sb.append(path[i])
      }
    }
    val ans = mutableListOf<String>()
    dfs(root, ans)
    return ans
  }
}