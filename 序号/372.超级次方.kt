
// 秦九韶算法，数组编译一次，每次计算log10+logI,I为每一位的数字，时间复杂度O(n*(log10+logI))
// 执行用时：220 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
// 内存消耗：36.1 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
// 通过测试用例：55 / 55
class Solution {
  fun superPow(a: Int, b: IntArray): Int {
    // 3^123 = 3^12^10 * 3^3
    // = ((3^1)^10*3^2)^10*3^3
    var ans = 1L;val mod = 1337
    for (i in b){
      ans=qpow(ans.toInt(),10,mod)%mod
      ans=ans*qpow(a,i,mod)%mod
    }
    return ans.toInt()
  }
  
  fun qpow(a:Int,b:Int,mod:Int):Long{
    var base=a.toLong();var pow = b;var ans = 1L
    while(pow>0){
      if(pow%2==1) ans=ans*base%mod
      base=base*base%mod
      pow/=2
    }
    return ans
  }
}

// 普通快速幂，对数组进行/2操作，K为数组表示的数，n为数组长度，时间复杂度O（n*logK）
// 执行用时：824 ms, 在所有 Kotlin 提交中击败了100.00% 的用户
// 内存消耗：37 MB, 在所有 Kotlin 提交中击败了100.00% 的用户
// 通过测试用例：55 / 55

class Solution {
  /* 对数组表示的很大的值/2 ，返回结果是否大于0 */
  fun dividePow(arr:IntArray):Boolean{
    var remain=0;var ans=false
    for (i in arr.indices){
      remain=remain*10+arr[i]
      arr[i]=remain/2
      if(!ans && arr[i]>0) ans=true
      remain%=2
    }
    return ans
  }
  fun superPow(a: Int, b: IntArray): Int {
    // a=base b=pow 结果对1337模
    val mod = 1337
    var ans = 1L;var base = a.toLong()
    while(true){
      if(b.last()%2==1){
        ans = ans*base%mod
      }
      base = base*base%mod
      if(!dividePow(b)) break
    }
    return ans.toInt()
  }
}