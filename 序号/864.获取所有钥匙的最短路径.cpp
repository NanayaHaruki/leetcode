class Solution {
 private:
  static constexpr int directions[4][2]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

 public:
  int shortestPathAllKeys(vector<string>& grid) {
    // 先知道起始点 几把锁和锁的位置，目的是拿到钥匙，而不是开锁；
    // . 空房间   #墙 @起点  a-f钥匙  A-F锁
    // bfs将每次能移动的路径加入queue
    int x0, y0,
        key = 0, m = grid.size(),
        n = grid[0].size();  // x0y0为起点，key存最多6把钥匙，a就放在0000
                             // 0001  b放在 0000 0010

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '@') {
          x0 = i;
          y0 = j;
        } else if (grid[i][j] - 'a' < 6 && grid[i][j]-'a'>=0) {
          key |= (1 << (grid[i][j] - 'a'));
        }
      }
    }
    // bfs
    // 记录点和钥匙状态，当钥匙状态==key时说明拿到所有钥匙了。根据当前钥匙状态也能判断下一步能否通过锁
    queue<tuple<int, int, int>> q;
    q.emplace(x0, y0, 0);
    // steps[i][j][k]
    // 为在i，j处的钥匙状态，可以重复通过同一个点，但钥匙状态必须不同，否则走重复路没有意义
    // k为0表示不携带钥匙；k为-1表示没走过这里
    vector<vector<vector<int>>> steps(
        m, vector<vector<int>>(n, vector<int>(key+1, -1)));
    steps[x0][y0][0] = 0;
    while (!q.empty()) {
      auto [x, y, k] = q.front();
      q.pop();
      for (int i = 0; i < 4; i++) {
        int nx = x + directions[i][0], ny = y + directions[i][1];
        if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == '#')
          continue;
        char c = grid[nx][ny];
        if (c - 'a' < 6 && c-'a'>=0) {  // 钥匙，更新状态
          int nk = k | (1 << (c - 'a'));
          if (steps[nx][ny][nk] == -1) {
            steps[nx][ny][nk] = steps[x][y][k] + 1;
            if (nk == key) return steps[nx][ny][nk];
            q.emplace(nx, ny, nk);
          }
        } else {  // 起点、空房间、锁（锁若有钥匙和空房间一样处理）
          if (c == '.' || c == '@' || (1 << (c - 'A') & k)) {
            if (steps[nx][ny][k] == -1) {
              steps[nx][ny][k] = steps[x][y][k] + 1;
              q.emplace(nx, ny, k);
            }
          }
        }
      }
    }
    return -1;
  }
};