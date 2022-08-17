//执行用时：128 ms, 在所有 Kotlin 提交中击败了61.90% 的用户
// 内存消耗：32.1 MB, 在所有 Kotlin 提交中击败了61.90% 的用户
// 通过测试用例：49 / 49
class Solution {
  fun translateNum(num: Int): Int {
    // num转字符串有几种转法 0-a 25-z
    // 斐波那契数列，跳楼梯同样的问题 fn=fn-1+fn-2，区别是跳一格随便跳，跳2格需要这2格满足10-25
    val nstr = num.toString()
    var pre2=0;var pre1=1;var cur=1
    for(i in 1 until nstr.length){
      pre2=pre1;pre1=cur;cur=pre1
      if (nstr[i-1]=='1' || nstr[i-1]=='2' && nstr[i]<='5')
        cur+=pre2
    }
    return cur
  }
}


//执行用时：164 ms, 在所有 Kotlin 提交中击败了9.52% 的用户
// 内存消耗：34.3 MB, 在所有 Kotlin 提交中击败了9.52% 的用户
// 通过测试用例：49 / 49
class Solution {
  fun translateNum(num: Int): Int {
    // i位要不用，必须i-1已经使用
    // i要用，可能性为i-1 用与没用之和
    val nstr = num.toString()
    val dp = Array(nstr.length){IntArray(2)}
    dp[0][1]=1
    if(nstr[0]<='2') dp[0][0]=1
    for(i in 1 until nstr.length){
      if(nstr[i]<='2') dp[i][0]=dp[i-1][1] // 当前位不用，小于2才可以和后面搭配，且前一位必须用掉了
      dp[i][1]=dp[i-1][1] // 用当前位，前一位也用掉了，数量直接转移
      if((nstr[i-1]=='2' && nstr[i]<='5') || (nstr[i-1]=='1')) // 当前位可以和前一位合并，再加上前一位没用的可能性
        dp[i][1]+=dp[i-1][0]
    }
    return dp.last()[1]
  }
}