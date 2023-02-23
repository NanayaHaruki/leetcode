#include <ctime>
#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

template <typename T>
void printVec(vector<T> &v) {
  for (T &t : v) {
    cout << t << endl;
  }
}
class Solution1 {
 public:
  unordered_set<int> uset;
  vector<int> vec;
  vector<int> circularPermutation(int n, int start) {
    dfs(n, start);
    return vec;
  }
  bool dfs(int n, int start) {
    if (vec.size() == pow(2, n)) return true;  // 已正确填满
    if (uset.count(start)) return false;       // 该数已被选择过
    if (vec.size() == (pow(2, n) - 1)) {       // 最后一个数，判断是否满足与第一个数的条件
      int c = vec[0] ^ start;
      if (!(c && ((c & (c - 1)) == 0))) return false;  // 判断这个数二进制表示下只有一个1
    }
    // 添加新数
    uset.insert(start);
    vec.push_back(start);
    cout << start << endl;
    // 找下一个可以选择的数
    for (int i = 0; i < n; ++i) {
      int next = start ^ (1 << i);
      bool flag = dfs(n, next);
      if (flag) {
        return true;
      }
    }
    // 回溯
    uset.erase(start);
    vec.pop_back();
    return false;
  }
};

class Solution {
 public:
  unordered_set<int> uset;
  vector<int> vec;
  int n;
  vector<int> circularPermutation(int _n, int start) {
    n = _n;
    uset.emplace(start);
    vec.emplace_back(start);
    dfs(start);
    return vec;
  }
  bool dfs(int x) {
    if (uset.size() == 1 << n) {
      int j = vec[0] ^ x;
      if (j && (j & (j - 1)) == 0) return true;
    }
    for (int i = 0; i < n; i++) {
      int newX = x ^ (1 << i);
      if (!uset.count(newX)) {
        uset.emplace(newX);
        vec.emplace_back(newX);
        if (dfs(newX)) {
          return true;
        } else {
          uset.erase(newX);
          vec.pop_back();
        }
      }
    }
    return false;
  }
};

int main() {
  Solution s1;
  auto v = s1.circularPermutation(6, 42);
  // printVec(v);
  return 0;
}