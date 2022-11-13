class Solution {
 public:
  vector<int> postorderTraversal(TreeNode *root) {
    vector<int> v;
    dfs(root, v);
    return v;
  }

  void dfs(TreeNode *n, vector<int> &v) {
    if (n == nullptr) return;
    dfs(n->left, v);
    dfs(n->right, v);
    v.emplace_back(n->val);
  }
};