class StockSpanner {
  deque<pair<int, int>> q;
  int idx = -1;

 public:
  /** 输入当天价格，返回连续小于等于当前价格的天数 */
  StockSpanner() { q.emplace_back(-1, 10001); }

  /**  栈内只保留比当前更大的数，每次存数据时弹出更小的，计算索引差 */
  int next(int price) {
    idx++;
    while (q.back().second <= price) {
      q.pop_back();
    }
    int ans = idx-q.back().first;
    q.emplace_back(idx, price);
    return ans;
  }
};