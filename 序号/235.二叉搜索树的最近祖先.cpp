class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root) return nullptr;
        if(root->val > p->val && root->val > q->val){// root比p q 都大，p q都在左树
            return lowestCommonAncestor(root->left,p,q);
        }else if(root->val < p->val && root->val < q->val){// 比p q小，p q在右树
            return lowestCommonAncestor(root->right,p,q);
        }else{
            return root; // root 在p q中间，则左边一个，右边一个，root就是最近祖先
        }
    }
};