
/**
 *  时间156 ms 20.24%
内存36.9 MB击败11.90%
 * 
 */
// class Solution {
//  public:
  /** towers[i]{x,y,q} , x y为坐标，q为信号强度。  某点信号强度为 q/（1+d）
   * d为与塔距离
   * 返回信号最强的点坐标。信号相同返回字典序最小。radius外的强度不考虑
   */

  // vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
  //   // 符号条件的点存起来，按照信号强度排序，取出强度最强的且字典序最小的
  //   unordered_map<int, int> map;
  //   int maxQ = 0;
  //   for (auto& tower : towers) {
  //     int x{tower[0]}, y{tower[1]}, q{tower[2]},
  //         minX = x < radius ? 0 : x - radius, maxX = x + radius,
  //         minY = y < radius ? 0 : y - radius, maxY = y + radius;
  //     // 遍历有信号的所有点
  //     if (q == 0) continue;
  //     maxQ=q;

  //     for (int a = minX; a <= maxX; a++) {
  //       for (int b = minY; b <= maxY; b++) {
  //         float d = sqrt((a - x) * (a - x) + (b - y) * (b - y));
  //         if (d > radius) continue;
  //         int signal = q / (1 + d);
  //         int xy = (a << 8) + b;
  //         map[xy] += signal;
  //       }
  //     }
  //   }
  //   if(maxQ==0) return {0,0};
  //   // 找信号最大，字典序最小的
  //   int a, b, c = 0;
  //   for (auto& pair : map) {
  //     int x = pair.first >> 8, y = pair.first & 255, q = pair.second;
  //     if (q > c) {  // 信号更强，更新所有数据
  //       c = q;
  //       a = x;
  //       b = y;
  //     } else if (q == c) {  // 信号相同
  //       if (x < a) {        // 横坐标更小
  //         a = x;
  //         b = y;  // 更新坐标
  //       } else if (x == a) {
  //         if (y < b) {  // 横坐标相同，纵坐标小
  //           b = y;      // 只需要更新纵坐标
  //         }
  //       }
  //     }
  //   }
  //   return vector<int>{a, b};
  // }

/**
 * 时间24 ms击败96.43%
内存14.4 MB击败20.24%
 * 
 */
class Solution {
 public:
  /** towers[i]{x,y,q} , x y为坐标，q为信号强度。  某点信号强度为 q/（1+d）
   * d为与塔距离
   * 返回信号最强的点坐标。信号相同返回字典序最小。radius外的强度不考虑
   */
  vector<int> bestCoordinate(vector<vector<int>>& towers, int radius) {
    // 符号条件的点存起来，按照信号强度排序，取出强度最强的且字典序最小的
    vector<vector<int>> v(101,vector<int>(101));
    for (auto& tower : towers) {
      int x{tower[0]}, y{tower[1]}, q{tower[2]},
          minX = x < radius ? 0 : x - radius, maxX = x + radius,
          minY = y < radius ? 0 : y - radius, maxY = y + radius;
      // 遍历有信号的所有点

      for (int a = minX; a <= maxX; a++) {
        for (int b = minY; b <= maxY; b++) {
          double d = sqrt((a - x) * (a - x) + (b - y) * (b - y));
          if (d > radius) continue;
          int signal = q / (1 + d);
          v[a][b]+=signal;
        }
      }
    }
    // 找信号最大，字典序最小的
    int a, b, c = 0;
    for (int x = 0;x<101;x++) {
      for(int y=0;y<101;y++){
        int q=v[x][y];
      if (q > c) {  // 信号更强，更新所有数据
        c = q;
        a = x;
        b = y;
      } else if (q == c) {  // 信号相同
        if (x < a) {        // 横坐标更小
          a = x;
          b = y;  // 更新坐标
        } else if (x == a) {
          if (y < b) {  // 横坐标相同，纵坐标小
            b = y;      // 只需要更新纵坐标
          }
        }
      }
      }
    }
    return vector<int>{a, b};
  }
};
};