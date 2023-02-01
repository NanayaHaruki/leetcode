class Solution {
 public:
  int maxProfit(vector<int>& inventory, int orders) {
    int l = 0, r = *max_element(inventory.begin(),inventory.end()), mod = 1e9 + 7;
    while (l + 1 < r) {
      int mid = l + (r - l)/2;
      int midOrders = 0;
      bool fit = false;
      for (int x : inventory) {
        if (x > mid) midOrders += x - mid;
        if (midOrders > orders) {
          fit = true;
          break;
        }
      }
      if (fit)
        l = mid;
      else
        r = mid;
    }
    // l 总和会大于orders，想要刚好等于orders，得选择大一个的r
    // 选择r=x，将>x 的降到x，剩余的操作次数就全是r的了
    long long ans = 0;
    for (int x : inventory) {
      if (x > r) {
        ans = (ans + (r + 1ll + x) * (x - r) /2) % mod;
        orders -= x - r;
      }
    }
    ans = (ans+1ll * r * orders) % mod;
    return int(ans);
  }
};