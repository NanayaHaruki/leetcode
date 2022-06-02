class Solution {
 public:
  TreeNode *deleteNode(TreeNode *root, int key) {
    // 删除固定节点，要求时间h，h为树高
    // 遍历到自己就删不了自己了，所以要从目标层的上一层删
    if (root == nullptr) return nullptr;
    if (key < root->val) {
      root->left = deleteNode(root->left, key);
    } else if (key > root->val) {
      root->right = deleteNode(root->right, key);
    } else {
      // 找到了，哪边为空就另一边接上
      if (root->left == nullptr && root->right == nullptr) {
        root = nullptr;
      } else if (root->left == nullptr && root->right != nullptr) {
        root = root->right;
      } else if (root->left != nullptr && root->right == nullptr) {
        root = root->left;
      } else {
        // 两边都有，右树接上，右树上最小的都比左数最大的大，左数要接在最左边的分支上
        minTree(root->right)->left = root->left;
        root = root->right;
      }
    }
    return root;
  }

  // 返回最左边的子树
  TreeNode *minTree(TreeNode *r) {
    if (r->left != nullptr) {
      return minTree(r->left);
    } else {
      return r;
    }
  }
};