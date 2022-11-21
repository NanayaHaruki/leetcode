
class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    // 将索引存起来，没出现过直接存索引，比对从0到该索引长度是否为最大
    // 出现过索引，比对长度，更新索引
    vector<int> dp(128, -1);
    int ans = 0, n = s.length(), l = -1;
    for (int i = 0; i < n; i++) {
      char c = s[i];
      l = max(l, dp[c] + 1);
      ans = max(ans, i - l + 1);
      dp[c]=i;
    }
    return ans;
  }
};
/*
执行用时：4 ms, 在所有 C++ 提交中击败了97.69% 的用户
内存消耗：8.1 MB, 在所有 C++ 提交中击败了65.06% 的用户
通过测试用例：987 / 987
*/
class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    unordered_map<char,int> m;
    int ans=0,l=0,r=0,n=s.size();
    while(r<n){
      char c = s[r];
      int lastIndex;
      if(m.find(c)==m.end()) lastIndex=-1;
      else lastIndex=m[c];
      l=max(l,lastIndex+1); // 如果有重复的，那么左边界从重复位置右边算起；如果重复位置在左边界左边，那么不用管
      ans=max(ans,r-l+1);
      m[c]=r;
      r++;
    }
    return ans;
  }
};