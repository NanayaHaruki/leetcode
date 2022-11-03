class Solution {
 public:
  /** word的连续重复次数 */
  int maxRepeating(string sequence, string word) {
    int m = sequence.size(), n = word.size(), ans = 0, times = m / n;
    string s;
    for (int i = 1; i <= times; i++) {
      s += word;
      int idx = sequence.find(s);
      if (idx == sequence.npos) {
        return i - 1;
      };
    }
    return times;
  }
};