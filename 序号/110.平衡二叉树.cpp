class Solution {
 public:
  int dfs(TreeNode* n) {
    if (!n) return 0;
    int l = dfs(n->left),r=dfs(n->right);
    if(l==-1 || r==-1 || abs(l-r)>1) return -1;
    return 1+max(l,r);
  }
  bool isBalanced(TreeNode* root) {
    return dfs(root)!=-1;
  }
};