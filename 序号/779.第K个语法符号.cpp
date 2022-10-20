class Solution {
 public:
  int kthGrammar(int n, int k) {
    // 每一层前面一半就是上一层，后面一半是上一层反过来
    // 根据索引是否大于一半，小于一半就等于上一层这个索引的值；大于索引则为上一层这个索引的反值；一直循环到第1层即可
    bool opposite = false;
    k -= 1;
    while (n > 1) {
      int preCnt = pow(2, n - 2);  // 上一层的个数
      if (k >= preCnt) {
        k %= preCnt;
        opposite = !opposite;
      }
      n--;
    }
    if (opposite)
      return 1;
    else
      return 0;
  };
};