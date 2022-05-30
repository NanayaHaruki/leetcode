class Solution {
  public:
  
  int minimumLines(vector<vector<int>> &stockPrices) {
    // stockPrices[i][0] 横坐标  [i][1]表示纵坐标，问整条线由几条线段构成
    // 先按x轴排序，寻找最大共线的点，2点确定一条线，从第3个点不断往后遍历判断是否与前面共线即可。
    // 难点在于斜率是浮点数，如何判定相等
    std::sort(stockPrices.begin(), stockPrices.end(), [&](vector<int> &v1, vector<int> &v2) {
      return v1[0] < v2[0];
    });
    int ans = 0;
    string k = "#";
    int size = stockPrices.size();
    for (int i = 1; i < size; ++i) {
      int x0 = stockPrices[i - 1][0], y0 = stockPrices[i - 1][1], x1 = stockPrices[i][0], y1 = stockPrices[i][1];
      int diffY = y0 - y1, diffX = x0 - x1;
      int diffAbsY = abs(diffY),diffAbsX = abs(diffX);
      int g = gcd(diffAbsX, diffAbsY);
      char op = '+';
      if ((diffY > 0 && diffX < 0)
        || (diffY < 0 && diffX > 0)) {
        op = '-';
      }
      string curK = op + to_string(diffAbsY / g) + '/' + to_string(diffAbsX / g);
      if (k == curK) {
        // 斜率相同，继续
      } else {
        ans++;
        k = curK;
      }
    }
    return ans;
  }
  
  /** 返回2数最大公约数 */
  int gcd(int a, int b) {
    if (b != 0) {
      return gcd(b, a % b);
    }
    return a;
  }
};