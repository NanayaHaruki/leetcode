class Solution {
public:
    /** 以root为根结点的所有二进制和 */
    int dfs(int i, TreeNode *root) {
        if (root == nullptr) return 0;
        i = i << 1 | root->val;
        int left = dfs(i,root->left);
        int right = dfs(i,root->right);
        if (root->left== nullptr && root->right== nullptr) return i;
        return left+right;
    }

    int sumRootToLeaf(TreeNode *root) {
        return dfs(0,root);
    }
};