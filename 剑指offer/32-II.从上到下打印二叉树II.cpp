class Solution {
 public:
  vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> v;
    if (!root) return v;
    queue<TreeNode*> q;
    q.push(root);
    TreeNode* n;
    while (!q.empty()) {
      int size = q.size();
      vector<int> layer;
      for (int i = 0; i < size; i++) {
        n = q.front();
        q.pop();
        layer.push_back(n->val);
        if (n->left) q.push(n->left);
        if (n->right) q.push(n->right);
      }
      v.push_back(layer);
    }
    return v;
  }
};