struct UF {
  vector<int> p;
  UF(int x) : p(vector<int>(x)) {
    for(int i=0;i<x;++i){
      p[i]=i;
    }
  }
  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  void connect(int x, int y) {
    int a = find(x), b = find(y);
    p[a] = b;
  }

  bool isConnect(int a, int b) {
    return find(a) == find(b);
  }
};

class Solution {
 public:
  bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
    UF uf(n);
    for(auto & edge:edges){
      uf.connect(edge[0],edge[1]);
    }
    return uf.isConnect(source,destination);
  }
};