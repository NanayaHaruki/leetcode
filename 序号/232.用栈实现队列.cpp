class MyQueue {
 private:
  stack<int> s1,
      s2;  // s1管插入；
           // 要弹出的时候s1弹出到s2，s2中就是反向的，栈顶就是队列的头。要插入时反向操作
 public:
  MyQueue() {}

  void push(int x) { s1.emplace(x); }

  int pop() {
    if (s2.empty()) {
      while (s1.size()) {
        int i = s1.top();
        s1.pop();
        s2.push(i);
      }
    }
    int i = s2.top();
    s2.pop();
    return i;
  }

  int peek() {
    if (s2.empty()) {
      while (s1.size()) {
        int i = s1.top();
        s1.pop();
        s2.emplace(i);
      }
    }
    return s2.top();
  }

  bool empty() { return s1.empty() && s2.empty(); }
};