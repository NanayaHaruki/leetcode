class Solution {
 public:
    priority_queue<int,vector<int>,greater<int>> pq;
    int kthLargest(TreeNode* root, int k) {
      // 求第k大的值
       pq.push(root->val);
      if(pq.size()>k) pq.pop();
      if(root->left) kthLargest(root->left,k);
      if(root->right) kthLargest(root->right,k);
      return pq.top();
    }
};