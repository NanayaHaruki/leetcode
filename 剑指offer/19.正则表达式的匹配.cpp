class Solution {
 public:
  /**　p 正则匹配 s； .匹配任意 *匹配前一个任意数量（数量可以为0）　*/
  bool isMatch(string s, string p) {
    int ns = s.size(), np = p.size();
    vector<vector<int> > dp(
        ns + 1,
        vector<int>(np + 1));  // dp[i][j]表示s的前i个字符和p的前j个字符可以匹配
    dp[0][0] = true;
    for (int i = 2; i <= np; i += 2) {
      if (p[i - 1] == '*') dp[0][i] = true;
      else break;
    }
    for (int i = 1; i <= ns; i++) {
      for (int j = 1; j <= np; j++) {
        char a = s[i-1], b = p[j-1];
        if (a == b || b == '.') {
          dp[i][j] = dp[i - 1][j - 1];  // 相等
          continue;
        }
        // 当前字符不能匹配，如果是*的话，还有希望
        if (b != '*') continue;
        // 当前是*,判断前面的
        // 用*重复0次将前一个字符干掉，比对2个字符前能否匹配
        if (dp[i][j - 2]) {
          dp[i][j] = true;
          continue;
        }
        // 前面一位可以匹配
        if (p[j - 2] == a || p[j - 2] == '.') {
          // * 重复1次
          if (dp[i - 1][j - 2]) {
            dp[i][j] = true;
            continue;
          }
          // * 重复多次
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[ns][np];
  }
};