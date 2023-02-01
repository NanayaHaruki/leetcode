class Solution {
 public:
  int findLatestStep(vector<int>& arr, int m) {
    auto cntMap = unordered_map<int, int>();  // 每个长度还有多少个
    auto lenMap = map<int, int>();            // 起始点->长度
    int n = arr.size(), ans = -1;
    bool f = false;  // 没形成长度为m的区间
    for (int i = 0; i < n; i++) {
      auto it = lenMap.lower_bound(arr[i]);  // arr 各不相同，所以lower_bound找的是大于arr[i]的第一个位置
      int rightStart = it->first, rightLen = it->second, leftStart, leftLen;
      bool fixLeft = false, fixRight = false;
      // 与后面的融合
      if (it != lenMap.end() && it->first == arr[i] + 1) {
        fixRight = true;
      }
      // 与前面的融合
      if (it != lenMap.begin()) {
        it--;
        leftStart = it->first, leftLen = it->second;
        if (leftStart + leftLen == arr[i]) {
          fixLeft = true;
        }
      }
      if (fixLeft && fixRight) {
        lenMap[leftStart] = rightLen + leftLen + 1;
        lenMap.erase(rightStart);
        cntMap[leftLen + rightLen + 1]++;
        cntMap[leftLen]--;
        cntMap[rightLen]--;
      } else if (fixLeft) {
        lenMap[leftStart] = leftLen + 1;
        cntMap[leftLen]--;
        cntMap[leftLen + 1]++;
      } else if (fixRight) {
        lenMap[rightStart - 1] = rightLen + 1;
        lenMap.erase(rightStart);
        cntMap[rightLen + 1]++;
        cntMap[rightLen]--;
      } else {
        lenMap[arr[i]] = 1;
        cntMap[1]++;
      }
      if (!f) {
        if (cntMap[m] > 0) f = true;
      }
      if (f) {
        if (cntMap[m] > 0) {
          ans = i + 1;
        } 
      }
    }
    return ans;
  }
};