class Solution {
 public:
  /** (x,y)为0，则将该行该列都置0 */
  void setZeroes(vector<vector<int>>& matrix) {
    // 用第一行和第一列记录当前行列需不需要置0；额外用两个变量计算第一行和第一列本身需不需要置0
    bool r0 = false, c0 = false;  // 第一行第一列用不用置0
    int m = matrix.size(), n = matrix[0].size();
    // 搜首行首列信息
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 0) {
        r0 = true;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        c0 = true;
        break;
      }
    }
    // 将其他行信息保存在首行首列
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    // 根据首行首列信息，将其他行列置0
    for (int i = 1; i < m; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < n; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int j = 1; j < n; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < m; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    // 修正首行首列信息
    if (r0) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    if (c0) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }
};