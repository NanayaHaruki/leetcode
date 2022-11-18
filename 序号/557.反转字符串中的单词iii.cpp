class Solution {
 public:
  string reverseWords(string s) {
    int idx = -1, n = s.length();
    for (int i = 0; i <= n; i++) {
      if (i == n || s[i] == ' ') {
        int l = idx+1,r=i-1;
        while(l<r){
          swap(s[l++],s[r--]);
        }
        idx=i;
      }
    }
    return s;
  }
};