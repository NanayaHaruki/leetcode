//执行用时：204 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
//内存消耗：34.4 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
//通过测试用例：74 / 74
import kotlin.math.abs
class Solution {
  fun decrypt(code: IntArray, k: Int): IntArray {
    val ans = IntArray(code.size)
    for (i in code.indices){
      ans[i]=calc(code,i,k)
    }
    return ans
  }
  
  /**
   * @param i 当前计算的索引
   * @param k k>0,计算后面k个数之和，k==0，当前索引为0；k<0,取前k个数之和
   * */
  fun calc(code:IntArray,i:Int,k:Int):Int{
    if (k==0){
      return 0
    }
    var direction = if (k>0) 1 else -1
    var idx = i;var sum = 0
    for (m in 0 until abs(k)){
      idx+=direction
      if (idx==-1) idx=code.size-1
      else if(idx==code.size) idx=0
      sum+=code[idx]
    }
    return sum
    
  }
}