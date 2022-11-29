class Solution {
 public:
  int minOperations(string s) {
    int n = s.length();
    char a = '1', b = '0', c;
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      c = s[i];
      if (a == '1') {
        if (c == '1') x++;
        a = '0';
      } else if (a == '0') {
        if (c == '0') x++;
        a = '1';
      }
      if (b == '0') {
        if (c == '0') y++;
        b = '1';
      } else if (b == '1') {
        if (c == '1') y++;
        b = '0';
      }
    }
    return min(x, y);
  }
};