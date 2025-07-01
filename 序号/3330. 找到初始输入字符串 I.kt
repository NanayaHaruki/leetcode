class Solution {
  fun possibleStringCount(word: String): Int {
    // 统计连续多次的字符，可能只想按1次，也可能就是想按这么多
    var ans = 0
    var p = '0'
    var cnt = 1
    for(c in word){
      if(c==p) {
          cnt++
      }else{
          ans+=cnt-1 // 输入错误有cnt-1种可能
          p=c
          cnt=1
      }
    }
    return ans+cnt // 最后一个输入错误是cnt-1 ,再加上整体全部正确的1
  }
}