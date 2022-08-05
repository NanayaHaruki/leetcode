class Solution {
public:
  int majorityElement(vector<int>& nums) {
    int half = nums.size() / 2;
    unordered_map<int, int> m;
    for (const int i : nums) {
      int c = m[i];
      if (c == half) return i;
      m[i]++;
    }
    return 0;
  }
};