class Solution {
 public:
  TreeNode* addOneRow(TreeNode* root, int val, int depth) {
    if (depth == 1) {
      return new TreeNode{val, root, nullptr};
    }
    int layer = 1, size;
    deque<TreeNode*> q{root};
    TreeNode* front;
    while (!q.empty()) {
      size = q.size();
      if (layer < depth - 1) {
        while (size > 0) {
          front = q.front();q.pop_front();
          if (front->left) q.push_back(front->left);
          if (front->right) q.push_back(front->right);
          size--;
        }
        layer++;
      } else {
        // 到达要目标层的上一层了，需要将这一层的节点都增加指定val的node，并将原左树接到新node的左树，右树接到新节点的右树
        while (size > 0) {
          front = q.front();
          q.pop_front();
          TreeNode *l = front->left, *r = front->right;
          front->left = new TreeNode(val, l, nullptr);
          front->right = new TreeNode(val, nullptr, r);
          size--;
        }
      }
    }
    return root;
  }
};