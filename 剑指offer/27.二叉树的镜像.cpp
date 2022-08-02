class Solution {
 public:
  TreeNode* mirrorTree(TreeNode* root) {
    if (root == nullptr) return nullptr;
    TreeNode* lt = mirrorTree(root->left);
    TreeNode* rt = mirrorTree(root->right);
    root->left = rt;
    root->right = lt;
    return root;
  }
};