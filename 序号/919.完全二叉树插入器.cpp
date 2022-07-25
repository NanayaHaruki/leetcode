/**
执行用时：24 ms, 在所有 C++ 提交中击败了35.69% 的用户
内存消耗：22 MB, 在所有 C++ 提交中击败了38.94% 的用户
通过测试用例：84 / 84
多维护一个队列用来保存待插入的节点，这样insert的时间就是O1
*/
class CBTInserter {
 private:
  TreeNode* r;
  deque<TreeNode*> cache;
 public:
  CBTInserter(TreeNode *root) {
    this->r = root;
    deque<TreeNode*> q;
    q.push_back(root);
    TreeNode* p;
    while(!q.empty()){
      p = q.front();
      if (p->left) q.push_back(p->left);
      if(p->right) q.push_back(p->right);
      if(!(p->left && p->right)) cache.push_back(p);
      q.pop_front();
    }
  }

  int insert(int val) {
    TreeNode* f= cache.front();
    TreeNode* c = new TreeNode(val);
    if(!f->left) f->left = c;
    else {
      f->right = c;
      cache.pop_front(); // 如果插到右节点了，说明满了可以从cache中弹出
    }
    cache.push_back(c);
    return f->val;
  }

  TreeNode *get_root() { return r; }
};
/*
执行用时：116 ms, 在所有 C++ 提交中击败了5.90% 的用户
内存消耗：62.6 MB, 在所有 C++ 提交中击败了5.31% 的用户
通过测试用例：84 / 84

初始化不耗时，每次插入bfs
*/
class CBTInserter {
 public:
  TreeNode *r;
  CBTInserter(TreeNode *root) { r = root; }

  int insert(int val) {
    // 找到可以插入的父节点
    // 层序遍历
    deque<TreeNode *> q;
    q.push_back(r);
    TreeNode *node;
    while (q.size() > 0) {
      node = q.front();
      q.pop_front();
      if (node->left == nullptr || node->right == nullptr)
        break;  // 先遍历到叶子为空，就直接返回，往他身上插
      q.push_back(node->left);
      q.push_back(node->right);
    }
    TreeNode * n =  new TreeNode(val);
    if(node->left==nullptr) {
      node->left = n;
      return node->val;
    }else{
      node->right = n;
      return node->val;
    }
  }



  TreeNode *get_root() { return r; }
};