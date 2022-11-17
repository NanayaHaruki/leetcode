class Solution {
 public:
  /** 返回子序列个数 */
  int numMatchingSubseq(string s, vector<string>& words) {
    vector<vector<int>> dict(26);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      dict[s[i] - 'a'].push_back(i);
    }

    for (auto& word : words) {
      bool f = true;
      int idx = -1;
      for (char c : word) {
        auto& v = dict[c - 'a'];
        auto it = upper_bound(v.begin(), v.end(), idx);
        if (it == v.end()) {
          f = false;
          break;  // 找不到，不是序列
        }
        idx = *it;
      }
      if (f) ans++;
    }

    return ans;
  }
};