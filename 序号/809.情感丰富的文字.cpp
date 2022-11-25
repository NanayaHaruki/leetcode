class Solution {
 public:
  int expressiveWords(string s, vector<string>& words) {
    // 可以将word中每个字符扩张到3个及以上，返回能扩张到s的个数
    // 遍历s，按照顺序数出每个字符的个数
    // 遍历words，每个word按照字符数量比对
    // 1. 数量相等，比对下一个字符；
    // 2. word中数量更多，不满足条件
    // 3. s中该字符数量更多，如果s大于等于3，那么ok，否则不满足（其实也就是等于2
    // 这一种情况了）

    vector<pair<char, int>> v;
    char a = 0;
    int k = 0;
    for (char c : s) {
      if (a == c)
        k++;
      else {
        if (a != 0) {
          v.emplace_back(a, k);
        }
        k = 1;
        a = c;
      }
    }
    v.emplace_back(a, k);
    int si, ans = 0, flag;
    for (auto& word : words) {
      a = k = 0;
      si = 0;flag=1;
      for (char c : word) {
        if (a == c)
          k++;
        else {
          if (a == 0) {
            a = c;
            k = 1;
            continue;
          }
          // 比对
          if (si == v.size() || a != v[si].first || k > v[si].second ||
              (k == 1 && v[si].second == 2)) {
            flag = false;
            break;
          }
          a = c;
          k = 1;
          si++;
        }
      }
      if (!flag) continue;

      if (si == v.size() - 1 && a == v[si].first &&
          (k == v[si].second || (k < v[si].second && v[si].second >= 3))) {
        ans++;
      }
    }
    return ans;
  }
};