class Solution {
public:
    int ans=0;
    int dfs(TreeNode* n){
        // n 这棵树的硬币总数-节点总数的绝对值 就是n与父节点之间的边的通过次数
        // dfs 返回每棵树的 |coins-nodes|
        if(!n) return 0;
        int d=dfs(n->left)+dfs(n->right)+n->val-1;
        ans+=abs(d);
        return d;
    }
    int distributeCoins(TreeNode* root) {
        dfs(root);
        return ans;
    }
};