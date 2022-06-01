/**
 * 22/06/01 created
 * queries为查询范围，返回arr中该范围的xor结果
 * */
class Solution {
  
  class Solution {
    lateinit var tree: IntArray
    /** 树状数组BIT*/
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
      buildTree(arr)
      val qn = queries.size
      val ans = IntArray(qn)
      for (i in 0 until qn){
        ans[i]= query(queries[i][1]) xor query((queries[i][0]-1))
      }
      return ans
    }
    
    fun query(i:Int):Int{
      var j = i+1
      var ans = 0
      while (j>0){
        ans = ans xor tree[j]
        j-=lowerBit(j)
      }
      return ans
    }
    
    fun buildTree(arr:IntArray){
      val n = arr.size
      val t = IntArray(n+1)
      for (i in arr.indices) {
        var j = i+1
        while (j<=n){
          t[j] = t[j] xor arr[i]
          j+= lowerBit(j)
        }
      }
      tree = t
    }
    
    fun lowerBit(i:Int) = i and -i
  }
  /*----------------*/
  
  /** 前缀和 */
  fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    // 区间查询，没有修改，优先前缀和
    val preXor = IntArray(arr.size+1)
    for (i in arr.indices) preXor[i+1]= preXor[i] xor arr[i]
    val ans = IntArray(queries.size)
    for (i in queries.indices){
      ans[i]=preXor[queries[i][1]+1] xor preXor[queries[i][0]]
    }
    return ans
  }
  
  
}