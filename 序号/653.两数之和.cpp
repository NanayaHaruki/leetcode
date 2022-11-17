
// 时间32 ms 击败83.28% 内存35.2 MB 击败96.66%
class Solution {
 public:
    TreeNode * cur,*root;
    bool binarySearch(TreeNode * n,int i){
      if(!n) return false;
      if(n->val==i && n!=cur) return true;
      if(n->val < i) return binarySearch(n->right,i);
      return binarySearch(n->left,i);
    }
    bool findTarget(TreeNode* n, int k) {
      if(!n) return false;
      if(!root) root=n;
      cur = n;
      // 利用bst性质，从根部搜索另一个数
      bool ans=false;
      ans = binarySearch(root,k-n->val);
      if(ans) return true;
      // 本节点找不到，找子树
      ans = findTarget(n->left,k);
      if(ans) return true
      return findTarget(n->right,k);
    }
};
/**
 * 时间48 ms击败20.87%内存40.7 MB击败6.36%
 * 没有利用bst性质
 */
// class Solution {
//  public:
//     unordered_set<int> set;
//     bool findTarget(TreeNode* root, int k) {
//       if(!root) return false;
//       if(set.find(k-root->val)!=set.end()) return true;
//       set.emplace(root->val);
//       return findTarget(root->left,k) | findTarget(root->right,k);
//     }
// };