class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // 找共同祖先
        if(nullptr==root) return nullptr;
        if (root==p || root==q) return root;
        TreeNode* l = lowestCommonAncestor(root->left,p,q);
        TreeNode* r = lowestCommonAncestor(root->right,p,q);
        if(nullptr==l) return r;
        if(nullptr==r) return l;
        return root;        
    }
};