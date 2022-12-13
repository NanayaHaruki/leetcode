class Solution {
 public:
  /** 连续序列和 */
  vector<vector<int>> findContinuousSequence(int target) {
    // 如果target为奇数，减半的两个数相加为一额外解；
    // 求出两两相乘的质因数 i*j
    //      j为奇数，则被乘数两边各自加上j/2的数即可组成答案序列
    //      j为偶数，则 被乘数为奇数，将奇数分成 i/2  i/2+1，并在两边加上j-1个数
    //      j为偶数，i也为偶数不成立
    vector<vector<int>> v;
    vector<pair<int, int>> t;
    unordered_set<int>
        lens;  // 下面几种加入方式可能会重，但一种长度只有一种可能性序列和为target，加入答案前判断一下以前有没加过
    for (int i = 2; i < target / 2; i++) {
      if (target % i == 0) {
        t.emplace_back(i, target / i);
      }
    }
    if (target % 2 == 1) {
      v.emplace_back(vector<int>{target / 2, target / 2 + 1});
    }
    int i, j;
    auto f = [&](int i, int j) {
      if (j % 2 == 1) {  // 乘数是奇数，直接被乘数两边加上 j/2 个数
        if (i - j / 2 >= 0) {
          if ((i - j / 2 != 0 && lens.find(j) == lens.end()) ||
              (i - j / 2 == 0 && lens.find(j - 1) == lens.end())) {
            vector<int> cur;
            for (int k = i - j / 2; k <= i + j / 2; k++) {
              if (k == 0) continue;
              cur.emplace_back(k);
            }
            v.emplace_back(cur);
            lens.emplace(cur.size());
          }
        }
        if (i % 2 == 1 && i / 2 - j + 1 >= 0) {  // 如果被乘数是奇数，可以再次减半，让乘数*2  (j-1)/2*2=j-1
          if ((i / 2 - j + 1 != 0 && lens.find(j * 2) == lens.end()) ||
              (i / 2 - j + 1 == 0 && lens.find(j * 2 - 1) == lens.end())) {
            vector<int> cur;
            for (int k = i / 2 - j + 1; k <= i / 2 + j; k++) {
              if (k == 0) continue;
              cur.emplace_back(k);
            }
            v.emplace_back(cur);
            lens.emplace(cur.size());
          }
        }
      } else {             // 乘数是偶数
        if (i % 2 == 1) {  // 被乘数是奇数
          if (i / 2 - j + 1 >= 0) {
            if ((i / 2 - j + 1 != 0 && lens.find(j * 2) == lens.end()) ||
                (i / 2 - j + 1 == 0 && lens.find(j * 2 - 1) == lens.end())) {
              vector<int> cur;
              for (int k = i / 2 - j + 1; k <= i / 2 + j; k++) {
                if (k == 0) continue;
                cur.emplace_back(k);
              }
              v.emplace_back(cur);
              lens.emplace(cur.size());
            }
          }
        }
      }
    };
    for (auto& pair : t) {
      i = pair.first, j = pair.second;
      // j做乘数
      f(i, j);
      f(j, i);
    }
    sort(v.begin(), v.end());
    return v;
  }
};