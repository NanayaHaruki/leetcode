class Solution {
 public:
  int minMoves(vector<int> &nums, int k) {
    // 1. 滑动窗口，在nums中找到k个1的子数组
    // 2. 窗口内有k个1，需要将所有的1交换位置到连续的某个位置。
    // 位置很难求，改为求将所有0都移除出这个窗口。
    //    每个0移除出去的交换次数，往左移的交换次数=左面1的个数。 右移同理。
    //    因为滑动窗口的长度是变化的， 如果遍历每个0，则时间复杂度为n^2。
    //    可以预处理整个nums得到每2个1中间的连续0个个数，得到的集合zeros，每k-1个数表示了k个1的子数组中间0的间隔。
    //    滑动窗口遍历时，zeros也在遍历，但zeros也有个滑动窗口，窗口长度固定为k-1，为常数级别。
    int l = 0, r = k - 1, m, n = nums.size(), ans, pre = 0;

    vector<int>
        idx;  // 存放1的索引
              // ,两个索引中间就是0的个数，判断0往左移还是右移次数少，加起来就是这个窗口的移动次数。
              // 移动窗口比对最少的次数
    for (int i = 0; i < n; i++) {
      if (nums[i]) idx.emplace_back(i);
    }
    // basecase
    for (int i = 1; i < k; i++) {
      if (i <= k / 2) {
        pre += (idx[i] - idx[i - 1] - 1) * i;
      } else {
        pre += (idx[i] - idx[i - 1] - 1) * (k - i);
      }
    }
    ans=pre;
    // cout << "base ans:" << ans << ',';
    int newAns;
    while (++r < idx.size()) {
      if (k % 2 == 0) {
        // int newAns = ans-(idx[r-k/2]-idx[r-k]-k/2)+(idx[r]-idx[r-k/2]-k/2);
        // 简化 去掉不必要的计算
        newAns = pre - 2 * idx[r - k / 2] + idx[r - k] + idx[r];
      } else {
        newAns = pre - (idx[r - k / 2 - 1] - idx[r - k] - k / 2) +
                 (idx[r] - idx[r - k / 2] - k / 2);
      }
      ans = min(newAns, ans);
      pre = newAns;
    }
    // cout<<ans<<endl;
    return ans;
  }
};