class Solution {
 public:
  double averageWaitingTime(vector<vector<int>>& customers) {
    long long totalWaitTime = 0;
    int pre = customers[0][0];
    for (auto& i : customers) {
      int arrive = i[0], cost = i[1];
      pre = max(pre, arrive);
      pre += cost;
      totalWaitTime += (pre - arrive);
    }
    return (double)totalWaitTime / customers.size();
  }
};