class Solution {
 public:
  vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> v;
    if (!root) return v;
    deque<TreeNode*> q;
    q.push_back(root);
    TreeNode* n;
    bool right = true;
    while (!q.empty()) {
      int size = q.size();
      vector<int> layer;
      for (int i = 0; i < size; i++) {
        if (right) {
          n = q.front();
          q.pop_front();
          if (n->left) q.push_back(n->left);
          if (n->right) q.push_back(n->right);
        } else {
          n = q.back();
          q.pop_back();
          if (n->right) q.push_front(n->right);
          if (n->left) q.push_front(n->left);
        }
        layer.push_back(n->val);
      }
      right = !right;
      v.push_back(layer);
    }
    return v;
  }
};