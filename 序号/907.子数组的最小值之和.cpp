class Solution {
 public:
  /** 对所有连续子数组中最小值求和 */
  int sumSubarrayMins(vector<int>& arr) {
    // 求出arr[i]是k个连续子数组的最小值，ans+=（arr[i]*k)
    // 对于k，需要知道每个i位置的左右多远有更小的数（出现等于的时候，左端点和右端点选择一个为闭区间即可，即左边允许相等，右边就不允许）
    // 对于遍历离自己多远有另一个数的问题，单调栈！。对于需要同时知道左右边界，2个单调栈
    int n = arr.size(),mod=1e9+7;
    vector<int> l(n,-1), r(n,n), s1, s2;  // l[i]表示arr[i]左边多远有更小的数
    
    for (int i = 0; i < n; i++) {
      while (!s1.empty() && arr[s1.back()] >= arr[i]) {
        s1.pop_back();
      }
      if (!s1.empty()) {
        // 栈顶比arr[i]小
        l[i] = i - s1.back();
      }else{
        l[i]=i+1;
      }
      s1.emplace_back(i);
      //--------------------
      while (!s2.empty() && arr[s2.back()] > arr[n - 1 - i]) {
        s2.pop_back();
      }

      if (!s2.empty()) {
        r[n - 1 - i] = s2.back() - (n - 1 - i);
      }else{
        r[n-1-i]=i+1;
      }
      s2.emplace_back(n - 1 - i);
    }
    long long ans=0;
    for(int i = 0;i<n;i++){
      ans += (long long)arr[i]*(l[i]*r[i]);
      ans %= mod;
    }
    return ans;
  }
};