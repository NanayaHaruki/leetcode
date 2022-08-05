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