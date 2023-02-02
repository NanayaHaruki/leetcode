class Solution {
 public:
  vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
    unordered_map<int, unordered_set<int>> redMap, blueMap;
    for (auto& edge : redEdges) {
      redMap[edge[0]].emplace(edge[1]);
    }
    for (auto& edge : blueEdges) {
      blueMap[edge[0]].emplace(edge[1]);
    }
    vector<int> ans(n, 0);

    for (int i = 1; i < n; ++i) {
      deque<pair<int, bool>> q;  // 到pair.first的路径是红的，second为true
      int steps = 0;
      bool find = false;
      unordered_set<int> path; // 用17位来存路径， 第1位 1位红 0为蓝。后面16位的前8位为起点，后8位为终点；n为100，8为足够存储编号了
      if (redMap.count(0)) {
        for (int edge : redMap[0]) {
          q.emplace_back(edge, true);
          path.emplace(edge+65536);// 65536 是将第1位改成1，中间的起点是0，所以直接加上终点edge即可
        }
      }
      if (blueMap.count(0)) {
        for (int edge : blueMap[0]) {
          q.emplace_back(edge, false);
          path.emplace(edge);
        }
      }

      while (q.size()) {
        steps++;
        size_t len = q.size();
        for (int j = 0; j < len; j++) {
          int k = q.front().first;
          bool isRed = q.front().second;
          q.pop_front();
          if (k == i) {
            find = true;
            break;
          }
          // 每次选择要选不一样颜色，且没用过的
          if (isRed) {
            if (blueMap.count(k)) {
              for (int edge : blueMap[k]) {
                int bluePath = (k << 8) + edge;
                if (path.count(bluePath) == 0) {
                  q.emplace_back(edge, false);
                  path.emplace(bluePath);
                }
              }
            }
          } else {
            if (redMap.count(k)) {
              for (int edge : redMap[k]) {
                int redPath = (k << 8) + edge + 65536;
                if (path.count(redPath) == 0) {
                  q.emplace_back(edge, true);
                  path.emplace(redPath);
                }
              }
            }
          }
        }
        if (find) {
          break;
        }
      }
      if (find) {
        ans[i] = steps;
      } else {
        ans[i] = -1;
      }
    }
    return ans;
  }
};