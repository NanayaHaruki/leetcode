class TreeAncestor(n: Int, parent: IntArray) {
  val dp:Array<IntArray>
  init {
    val m=32-Integer.numberOfLeadingZeros(n)
    dp=Array(n){IntArray(m){-1} } // 定义dp[i][j] 为i第2^j层父节点  j=0时为第1个父节点
    for(i in 0 until n){
      dp[i][0]=parent[i]
    }
    // 从每个叶子节点往上找，遍历时层级放在外循环，叶子放在内循环
    for(j in 0 until m-1){
      for(i in 0 until n){
        val p = dp[i][j]
        if(p!=-1){ // 找到2^j层父节点了，翻倍找j+1，用p的2^j来更新
          dp[i][j+1]=dp[p][j] // 更新的是j+1层，p的j层必定更新过了
        }
      }
    }


  }
  fun getKthAncestor(node: Int, k: Int): Int {
    // 任意数字都可以写成2的幂之和的形式，统计每个叶节点2的幂层父节点即可
    val m=32-Integer.numberOfLeadingZeros(k)
    var ans=node
    for(j in 0 until m){
      if ((k shr j) and 1==1){
        ans=dp[ans][j]
        if(ans==-1) break;
      }
    }
    return ans
  }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * var obj = TreeAncestor(n, parent)
 * var param_1 = obj.getKthAncestor(node,k)
 */