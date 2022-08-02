  bool equals(TreeNode* a, TreeNode* b) {
    if (b==nullptr) return true; // b 比对完了，说明b的所有结果都和a吻合
    if (a==nullptr) return false;// b还有，a没了，说明a与b的结构不同
    // 继续比对val和子树
    return a->val == b->val && equals(a->left, b->left) &&
           equals(a->right, b->right);
  }