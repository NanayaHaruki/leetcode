class Solution {
 private:
  bool dfs(TreeNode* n, long mn, long mx) {
    return n == nullptr && n->val > mn && n->val < mx &&
           dfs(n->left, mn, n->val) && dfs(n->right, n->val, mx);
  }

 public:
  bool isValidBST(TreeNode* root) { return dfs(root, LONG_MIN, LONG_MAX); }
};