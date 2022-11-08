class Solution {
 public:
  bool isValidSudoku(vector<vector<char>>& board) {
    // 验证数独是否有效（不要求有解）
    // 反正是9*9 ，最多81*9*3次判断
    int m = board.size(), n = board[0].size();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        char c = board[i][j];
        if (c == '.') continue;
        // 判断行
        for (int k = 0; k < n; k++) {
          if(k==j) continue;
          if (c == board[i][k]) return false;
        }
        // 判断列
        for (int k = 0; k < m; k++) {
          if(k==i) continue;
          if (c == board[k][j]) return false;
        }
        // 判断九宫格
        exist = false;
        int left = j / 3 * 3, top = i / 3 * 3;
        for (int x = top; x < top + 3; x++) {
          for (int y = left; y < left + 3; y++) {
            if(x==i && y==j) continue;
            if (c == board[x][y])return false;
          }
        }
      }
    }
    return true;
  }
};