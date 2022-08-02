class Solution {
 private:
  TreeNode* build(vector<int>& pre, int preStartIndex, int preEndIndex,
                  vector<int>& in, int inStartIndex, int inEndIndex) {
    if (preStartIndex > preEndIndex || inStartIndex > inEndIndex)
      return nullptr;
    if (preStartIndex==preEndIndex)
      return new TreeNode(pre[preStartIndex]);


    int v = pre[preStartIndex];
    int i = inStartIndex;  // 顶点在中序中的位置
    while (in[i] != v) i++;
    int leftTreeLength = i - 1 - inStartIndex;
    int rightTreeLength = inEndIndex - i - 1;

    TreeNode* n = new TreeNode(v);
    TreeNode* lt =build(pre, preStartIndex + 1, preStartIndex + 1 + leftTreeLength,
                    in, inStartIndex, i - 1);
    TreeNode* rt = build(pre, preStartIndex + 1 + leftTreeLength + 1,
                               preEndIndex, in, i + 1, inEndIndex);
    n->left = lt;
    n->right = rt;
    return n;
  }

 public:
  TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    // 前序遍历 先root 再左树 再右树； 中序遍历 先左树 再自己 再右树
    // 数字不重复，前序的定点去中序找，找到位置后 左右两树的长度就搞定了
    return build(preorder, 0, preorder.size() - 1, inorder, 0,
                 inorder.size() - 1);
  }
};