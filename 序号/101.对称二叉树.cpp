/*
迭代
执行用时：8 ms, 在所有 C++ 提交中击败了26.15% 的用户
内存消耗：15.7 MB, 在所有 C++ 提交中击败了91.03% 的用户
通过测试用例：195 / 195
*/
class Solution {
 public:
  bool isMirror(TreeNode* l,TreeNode* r){
      if(!l && !r) return true;
      if(l && !r) return false;
      if(!l && r) return false;
      if(l->val != r->val) return false;
      return isMirror(l->left,r->right) && isMirror(l->right,r->left);
  }
  bool isSymmetric(TreeNode* root) {
    if(!root) return true;
    return isMirror(root->left,root->right);
  }
};

class Solution {
 public:
  bool isSymmetric(TreeNode* root) {
    if (root == nullptr) return true;
    // bfs 每层对比
    deque<TreeNode*> q;
    q.push_back(root->left);
    q.push_back(root->right);
    while (q.size() > 0) {
      int size = q.size();
      // 判断是否都是null
      int nullCnt = 0;
      for (const TreeNode* i : q) {
        if (i == nullptr) nullCnt++;
      }
      if (nullCnt == size) {
        return true;
      }
      while (size > 0) {
        TreeNode* front = q.front();
        TreeNode* back = q.back();
        if (front == nullptr && back == nullptr) {
          q.pop_back();
          q.pop_front();
          size -= 2;
        } else if (front != nullptr && back != nullptr &&
                   front->val == back->val) {
          q.pop_back();
          q.pop_front();
          size -= 2;
          q.push_front(front->right);
          q.push_front(front->left);
          q.push_back(back->left);
          q.push_back(back->right);
        } else
          return false;
      }
    }
    return true;
  }
};