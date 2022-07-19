
/**珂朵莉树实现

*/
struct Node {
  int start;
  int end;
  mutable int v;
  bool operator<(const Node &a) const { return start < a.start; }
  Node(const int &a, const int &b, const int &v) : start(a), end(b), v(v) {}
};
class MyCalendarTwo {
 private:
  set<Node> tree;

 public:
  MyCalendarTwo() { tree.insert(Node(0, (int)1e9, 0)); }

  auto split(int x) {
    Node nx = Node(x, 0, 0);
    nx.start = x;
    auto it = tree.upper_bound(nx);
    it--;
    if (it->start == x) return it;
    // lower than x
    int l = it->start, r = it->end, v = it->v;
    tree.erase(it);
    tree.insert(Node(l, x - 1, v));
    auto t = tree.insert(Node(x, r, v)).first;
    return t;
  }

  bool book(int start, int end) {
    auto r = split(end), l = split(start);
    auto t = l;
    bool canBook = true;
    while (l != r) {
      if (l->v >= 2) {
        canBook = false;
        break;
      }
      l++;
    }
    if (!canBook) return false;
    l=t;
    while (l != r) {
      l->v++;
      l++;
    }
    return true;
  }
};