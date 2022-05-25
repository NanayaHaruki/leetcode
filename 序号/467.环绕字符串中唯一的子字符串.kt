fun findSubstringInWraproundString(p: String): Int {
  // 找p的子串数量，且满足是"..zabc..z"
  // 以x结尾的长串 必然包含以x结尾的短串，以x结尾的字符串子串 = 字符串长度
  // dp[i] 为以i-'a' 结尾的最大子串长度
  val dp = IntArray(26)
  var maxLen = 0
  for (i in p.indices){
    if (i==0) maxLen=1
    else{
      if (p[i]-p[i-1]==1 || (p[i-1]=='z'&&p[i]=='a') ) maxLen++
      else maxLen=1
    }
    dp[p[i]-'a']= maxOf( maxLen,dp[p[i]-'a'])
  }
  return dp.sum()
}