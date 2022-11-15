class Solution {
 public:
  TreeNode* invertTree(TreeNode* root) {
    if (!root) return root;
    TreeNode *right = invertTree(root->right), *left = invertTree(root->left);
    root->left = right;
    root->right = left;
    return root;
  }
};