class Solution {
 public:
  /** 可能的括号对数 */
  vector<string> generateParenthesis(int n) {
    // 每次将一个（）放在不同的位置上
    if (n == 1) return vector<string>{"()"};
    unordered_set<string> set;
    vector<string> ans;
    string tmp;
    vector<string> v{generateParenthesis(n - 1)};
    for (auto& s : v) {
      for (int i = 0; i < 2 * (n - 1); i++) {
        tmp = s.substr(0, i) + "()" + s.substr(i);
        if (set.count(tmp) == 0) {
          ans.emplace_back(tmp);
          set.emplace(tmp);
        }
      }
    }
    return ans;
  }
};