class Solution {
 public:
  int minimumTotal(vector<vector<int>> &triangle) {
    // 每个点的路径由上一层两个点过来，取小的那个
    if(triangle.size()==1) return triangle[0][0];
    int ans = INT_MAX;
    for (int i = 1; i < triangle.size(); i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          triangle[i][j] += triangle[i - 1][j];
        } else if (j == i) {
          triangle[i][j] += triangle[i - 1][j - 1];
        } else {
          triangle[i][j] =
              min(triangle[i - 1][j], triangle[i - 1][j - 1]) + triangle[i][j];
        }
        if (i == triangle.size() - 1) {
          ans = min(ans, triangle[i][j]);
        }
      }
    }
    return ans;
  }
};