class Solution {
 public:
  vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
    vector<vector<int>> v(heights.size(), vector<int>(2));
    for (int i = 0; i < heights.size(); i++) {
      v[i] = {heights[i], i};
    }
    vector<string> ans(heights.size());
    auto cmp = [](vector<int> const& a, vector<int> const& b) {
      return a[0]>b[0];
    };
    sort(v.begin(), v.end(), cmp);

    for (int i = 0; i < heights.size(); i++) {
      ans[i] = names[v[i][1]];
    }
    return ans;
  }
};