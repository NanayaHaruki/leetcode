class Solution {
  int direction[4][2]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  int row, col;
  deque<pair<int, int>> island;
  void dfs(vector<vector<int>>& grid, int i, int j) {
    if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) return;
    island.emplace_back(i, j);
    grid[i][j] = -1;
    for (auto& d : direction) {
      dfs(grid, i + d[0], j + d[1]);
    }
  }

  int bfs(vector<vector<int>>& grid) {
    int step = 0;
    while (!island.empty()) {
      int size = island.size();
      for (int k = 0; k < size; k++) {
        auto [x, y] = island.front();
        island.pop_front();
        for (auto& d : direction) {
          int newX = x + d[0], newY = y + d[1];
          if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
            int newVal = grid[newX][newY];
            if (newVal == 0) {  // 扩散到新的海域了，加进队列
              grid[newX][newY] = -1;
              island.emplace_back(newX,newY);
            }else if(newVal==1){ // 找到第二个岛了，直接返回
              return step;
            }else if(newVal==-1){ // 本岛，啥都不做

            }
          }
        }
      }
      step++;
    }
    return 0;
  }

 public:
  /** 找两岛间桥的最短距离 */
  int shortestBridge(vector<vector<int>>& grid) {
    // 找到一个岛，将这个岛更改为-1,可以dfs，可以bfs
    row = grid.size();
    col = grid[0].size();
    for (int i = 0; i < row; i++) {
      bool find = false;
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {  // 找到一个岛
          dfs(grid, i, j);      // 将该岛所有值更改为-1，加进队列
          return bfs(grid);  // 从队列中取出岛中的坐标，向四周扩散，将新的0变成成-1，直到找到1新的岛，扩散了多少次就是桥的最短距离
          find = true;
          break;
        }
      }
      if (find) break;
    }
    return 0;
  }
};