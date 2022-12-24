class Solution {
 public:
  string largestMerge(string_view word1, string_view word2) {
    size_t m = word1.size(), n = word2.size(), i = 0, j = 0;
    string ans;
    while (i < m && j < n) {
      char a = word1[i], b = word2[j];
      if (word1.substr(i) > word2.substr(j)) {
        ans += word1[i++];
      } else  {
        ans+=word2[j++];
      }
    }
    while (i < m) ans += word1[i++];
    while (j < n) ans += word2[j++];
    return ans;
  }
};