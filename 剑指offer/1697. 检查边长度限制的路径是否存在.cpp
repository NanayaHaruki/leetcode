class Solution {
 private:
  vector<int>* p;
  void un(int i, int j) {
    int a = find(i);
    int b = find(j);
    (*p)[a] = b;
  }

  int find(int x) {
    if ((*p)[x] != x) {
      (*p)[x] = find((*p)[x]);
    }
    return (*p)[x];
  }

 public:
  /**  edgeList三个数i,j,k，表示i到j的距离； 检查queries[0]到queries[1]的距离是否每条边都有小于queries[2]的路径 */
  vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& queries) {
    // 离线思维，将edgeList按照距离排序， 再将queries按照limit排序，每次查询前，将指向edgeList的指针移动到大于limit的位置，移动时将两点小于limit的两点连接，这样查询的两点只要连通，他们之间的所有边就是满足limit要求的。
    // 并查集，维护两点是否联通
    vector<bool> ans(queries.size());
    p = new vector<int>(n);
    iota(p->begin(), p->end(), 0);  // p用来保存queries的索引
    vector<int> sortedQ(queries.size());
    iota(sortedQ.begin(),sortedQ.end(),0);
    // 按照queries的limit将p的索引排序
    sort(sortedQ.begin(), sortedQ.end(), [&queries](int i, int j) {
      return queries[i][2] < queries[j][2];
    });
    sort(edgeList.begin(), edgeList.end(), [&](const auto& a, const auto& b) {
      return a[2] < b[2];
    });

    int edgeIdx = 0;
    for (int queryIdx : sortedQ) {
      while (edgeIdx < edgeList.size() && edgeList[edgeIdx][2] < queries[queryIdx][2]) {
        un(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
        edgeIdx++;
      }
      ans[queryIdx] = find(queries[queryIdx][0]) == find(queries[queryIdx][1]);
    }
    delete p;
    return ans;
  }
};