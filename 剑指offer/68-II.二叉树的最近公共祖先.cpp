class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return nullptr;
        if(root==p || root==q) return root;
        TreeNode* l = lowestCommonAncestor(root->left,p,q),*r = lowestCommonAncestor(root->right,p,q);
        if(!l) return r;
        if(!r) return l;
        return root;
    }
};