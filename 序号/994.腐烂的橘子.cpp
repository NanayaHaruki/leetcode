class Solution {
  int dirs[4][2]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

 public:
  /** 0空 1good 2 bad 返回全bad的分钟数 */
  int orangesRotting(vector<vector<int>>& grid) {
    // 多源bfs，先讲烂橘子加进队列，每次向四方向扩散，将四方向的新鲜橘子加进队列。
    // 队列为空，还有新鲜橘子，返回-1 ； 最后一个新鲜橘子被传到，返回step
    queue<pair<int, int>> q;
    int rows = grid.size(), cols = grid[0].size(), goodCnt = 0, x, y, nx, ny,
        step = -1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 2) {
          q.emplace(i, j);
        } else if (grid[i][j] == 1) {
          goodCnt++;
        }
      }
    }
    if(goodCnt==0) return 0; // 没有好的，直接返回时间0
    if (q.empty()) return -1;// 没有坏的，返回-1，不可能；
    while (!q.empty()) {
      size_t len = q.size();
      step++;
      for (int i = 0; i < len; i++) {
        x = q.front().first;
        y = q.front().second;
        q.pop();
        if (grid[x][y] == 1) {
          grid[x][y] = -1;
          goodCnt--;
          if(goodCnt==0) return step;
        }
        for (auto& dir : dirs) {
          nx = x + dir[0];
          ny = y + dir[1];
          if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1)
            q.emplace(nx, ny);
        }
      }
    }
    return -1;
  }
};