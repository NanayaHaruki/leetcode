/*
执行用时：4 ms, 在所有 C++ 提交中击败了90.26% 的用户
内存消耗：18.3 MB, 在所有 C++ 提交中击败了63.91% 的用户
通过测试用例：39 / 39
*/
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root) return 0;
        return 1+max(maxDepth(root->left),maxDepth(root->right));
    }
};


/*
执行用时: 0 ms
内存消耗: 18.4 MB
*/
class Solution {
public:
    int ans = 0;
    void dfs(TreeNode* n,int depth){
        if(!n) return;
        ans=max(ans,depth+1);
        dfs(n->left,depth+1);
        dfs(n->right,depth+1);
    }
    int maxDepth(TreeNode* root) {
        if(!root) return 0;
        ans=0;
        dfs(root,0);
        return ans;
    }
};