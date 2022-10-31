class Solution {
 public:
  /** 字符串只有1、2   由1和2的连续次数可以构造出这个字符串，问长度n里有多少个1
   */
  int magicalString(int n) {
    // 只能1和2，根据次数交替生成后面
    // 当前有3个数，执行到第2个数，即第一个2接在1后面，表示1不能继续了，得用2接在第一个1后面，接几个2呢，2个。
    // 现在循环开始处理第2个2，因为2不能继续了，后面必须接1，接几个1呢，2个
    vector<int> str{1, 2, 2};
    int l = 2, len = 3, ans = 1;
    while (len < n) {
      int cnt = str[l];        // 要接几个数字
      int c = 3 - str.back();  //要接什么数字
      for (int i = 0; i < cnt; i++) str.emplace_back(c);
      l++;
      len += cnt;
      if (c == 1) {
        // 一次只会加1个或2个数字，有可能正好加多了；本来长度是n-1，加了两个，变成n+1，多加的那个要减掉
        ans += len <= n ? cnt : cnt - 1; 
      }
    }
    return ans;
  }
};