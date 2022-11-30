class FreqStack {
  unordered_map<int, int> cnts;          // key为元素，value为次数
  unordered_map<int, vector<int>> vals;  // key为次数，value为元素集合
  int mx = 0;

 public:
  FreqStack() {}

  void push(int val) {
    cnts[val]++;
    mx = max(mx, cnts[val]);
    vals[cnts[val]].emplace_back(val);
  }

  int pop() {
    int ans, size = vals[mx].size();
    ans = vals[mx][size - 1];
    vals[mx].pop_back();
    cnts[ans]--;
    if (size == 1) mx--;
  }
};