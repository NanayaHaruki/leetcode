class Solution {
  fun groupStrings(words: Array<String>): IntArray {
    // 字符串增删改一个字母后相同，字母集合相同，则字符串是"关联的"
    // 返回words能分成多少个关联的组，和最大的组的长度，分组方案唯一
    // 关联性用并查集记录，【为了判断是否存在于集合中，用哈希并查集】
    val uf = UF(words.size)
    // 先初始化并查集，将字母集合转成二进制存储
    for (i in words.indices) {
      val word = words[i] // 因为字母不重复，转成二进制
      var binary = 0
      for(c in word){
        binary += 1 shl (c-'a')
      }
      if (uf.p.contains(binary)){
        uf.sz[binary] = uf.sz[binary]!!+1
        if(uf.sz[binary]!!>uf.maxSz) uf.maxSz=uf.sz[binary]!!
      }else{
        uf.p[binary]=binary
        uf.sz[binary]=1
        uf.groups++
      }
    }
    // 遍历每个字符串，将其增删改的结果计算出来，检查是否存在于集合中，如果是，连接起来。
    for(key in uf.p.keys){
      for (i in 0 until 26){
        val bit = 1 shl i
        // 0 变成 1，就是加上了某个字母。1 异或后成0了，就是将某个字母删除
        val unionKey = key xor bit
        uf.union(key,unionKey)
        // 增删搞定了，还剩下改。如果当前位是1，改成0，检查其他是0的位置，挑一个变成1
        if((key and bit) == bit){
          for (j in 0 until 26){
            val bit2 = 1 shl j
            if((key and bit2)==0){
              val unionKey2 = key xor bit xor bit2
              uf.union(key,unionKey2)
            }
          }
        }
      }
    }
    return intArrayOf(uf.groups,uf.maxSz)
  }
}

class UF(n: Int) {
  val p= mutableMapOf<Int,Int>()
  var groups = 0
  var sz = mutableMapOf<Int,Int>()
  var maxSz = 1

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x]!!)
    }
    return p[x]!!
  }

  fun union(i: Int, j: Int) {
    if (!p.contains(j)) return
    val fi = find(i)
    val fj = find(j)
    if (fi == fj) return
    p[fi] = fj
    groups--
    sz[fj] =  sz[fj]!!+ sz[fi]!!
    sz[fi]=0
    if (sz[fj]!! > maxSz) {
      maxSz = sz[fj]!!
    }
  }
}