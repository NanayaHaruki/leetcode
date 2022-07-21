class Solution {
public:
int sum(TreeNode * node){
  if (node==nullptr)
  {
    return 0;
  }
  int l = sum(node->left);
  int r =sum(node->right);
  if (l==0)
  {
    node->left=nullptr;
  }
  if(r==0){
    node->right=nullptr;
  }

  return node->val+sum(node->left)+sum(node->right);
}

TreeNode *pruneTree(TreeNode *root) {
  int s = sum(root);
  if(s==0 && root->val==0) return nullptr;
  else return root;
}
};