class Solution {
 public:
  vector<int> preorderTraversal(TreeNode *root) {
    vector<int> v;
    dfs(root,v);
    return v;
  }

  void dfs(TreeNode *n, vector<int> &v) {
    if (n == nullptr) return;
    v.emplace_back(n->val);
    dfs(n->left,v);dfs(n->right,v);
  }
};