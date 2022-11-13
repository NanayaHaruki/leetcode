class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> v;
        dfs(root,v);
        return v;
    }

    void dfs(TreeNode * n,vector<int> &v){
      if(n==nullptr) return;
      dfs(n->left,v);
      v.emplace_back(n->val);
      dfs(n->right,v);
    }
};