/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*> allPossibleFBT(int n) {
        if((n&1)==0) return {};
        if(n==1) return {new TreeNode(0)};
        vector<TreeNode*> v;
        for(int i=0;i<n;i++){
          vector<TreeNode*> left = allPossibleFBT(i),right = allPossibleFBT(n-1-i);
          for(TreeNode* l:left){
            for(TreeNode* r : right){
              TreeNode* root = new TreeNode(0,l,r);
              v.emplace_back(root);
            }
          }
        }
        return v;
    }
};