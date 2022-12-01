class Solution {
 public:
  int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
    int idx = -1, minDis = -1, n = points.size(), curDis;
    for (int i = 0; i < n; i++) {
      if (points[i][0] != x && points[i][1] != y) continue;
      curDis = abs(x - points[i][0]) + abs(y - points[i][1]);
      if (idx == -1) {
        idx = i;
        minDis = curDis;
      } else {
        if (curDis < minDis) {
          idx = i;minDis=curDis;
        }
      }
    }
    return idx;
  }
};