/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* getTargetCopy(TreeNode* o, TreeNode* c, TreeNode* t) {
            // std::cout<<o<<','<<c<<','<<t<<std::endl;
            if(o==nullptr) return o;
            if(o==t) return c;
            
            TreeNode * ans = getTargetCopy(o->left,c->left,t);
            if(ans) return ans;
            return getTargetCopy(o->right,c->right,t);   
        
    }
};