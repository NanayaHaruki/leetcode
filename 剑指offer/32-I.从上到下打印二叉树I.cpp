class Solution {
public:
    vector<int> levelOrder(TreeNode* root) {
      vector<int> v;
      if(!root) return  v;
      queue<TreeNode*> q ;
      q.push(root);
      TreeNode* n;
      while(!q.empty()){
        n= q.front();
        q.pop();
        v.push_back(n->val);
        if(n->left) q.push(n->left);
        if(n->right) q.push(n->right);
      }
      return v;
    }
};