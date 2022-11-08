class Solution {
 public:
  int countConsistentStrings(string allowed, vector<string>& words) {
    bool chars[26]{0};
    for (auto c : allowed) chars[c - 'a'] = true;
    int ans = 0;
    for (auto& str : words) {
      bool match = true;
      for (auto c : str) {
        if (!chars[c - 'a']) {
          match = false ;break;
        }
      }
      if (match) ans++;
    }
    return ans;
  }
};