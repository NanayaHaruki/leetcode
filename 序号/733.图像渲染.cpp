class Solution {
  vector<vector<int>> dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

 public:
  /** 与（sr，sc）相同的值且相连，变更为新的color*/
  vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc,
                                int color) {
    int oldColor = image[sr][sc];
    if (oldColor == color) return image;
    deque<pair<int, int>> q;
    int rows = image.size(), cols = image[0].size();
    q.emplace_back(sr, sc);
    int r, c;
    while (!q.empty()) {
      r = q.front().first;
      c = q.front().second;
      q.pop_front();
      image[r][c] = color;
      for (auto& dir : dirs) {
        int nr = r + dir[0], nc = c + dir[1];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
            image[nr][nc] == oldColor) {
          q.emplace_back(nr, nc);
        }
      }
    }
    return image;
  }
};