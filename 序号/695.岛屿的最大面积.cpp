class Solution {
  vector<vector<int>> dirs{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  int rows, cols;

 public:
  int bfs(vector<vector<int>>& grid, int r0, int c0) {
    deque<pair<int, int>> q;
    int ans = 0;
    q.emplace_back(r0, c0);
    int r, c;
    while (!q.empty()) {
      r = q.front().first;
      c = q.front().second;
      if(grid[r][c]!=1) continue;
      grid[r][c] = -1;
      ans++;
      for (auto& dir : dirs) {
        int nr = r + dir[0], nc = c + dir[1];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
          q.emplace_back(nr, nc);
        }
      }
    }
    return ans;
  }

  int dfs(vector<vector<int>> &grid, int r0, int c0) {
    if (r0 < 0 || r0 >= rows || c0 < 0 || c0 >= cols || grid[r0][c0] != 1)
      return 0;
    grid[r0][c0] = -1;
    return 1 + dfs(grid, r0 + 1, c0) + dfs(grid, r0 - 1, c0) +
           dfs(grid, r0, c0 + 1) + dfs(grid, r0, c0 - 1);
  }
  
  int maxAreaOfIsland(vector<vector<int>>& grid) {
    rows = grid.size();
    cols = grid[0].size();
    int ans = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          // ans = max(ans, bfs(grid, i, j));
          ans = max(ans, dfs(grid, i, j));
        }
      }
    }
    return ans;
  }
};