class Solution {
 public:
  Node* connect(Node* root) {
    if (!root) return root;
    deque<Node*> q{root};
    while (!q.empty()) {
      auto len = q.size();
      for (int i = 0; i < len; i++) {
        Node* f = q.front();
        q.pop_front();
        if (i != len - 1) {
          f->next = q.front();
        }
        if (f->left != nullptr) {  // 完美二叉树 判断一边就行
          q.emplace_back(f->left);
          q.emplace_back(f->right);
        }
      }
    }
    return root;
  }
};