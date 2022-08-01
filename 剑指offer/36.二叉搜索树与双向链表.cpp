class Solution {
public:
    Node * head=nullptr,*pre=nullptr;
    void dfs(Node* root){
      if (root==nullptr) return;
      // bst 中序遍历自然就排序了
      dfs(root->left);

      // 中序 干活在两树递归之间
      // pre不为空，将pre右边指向当前节点
      if(pre!=nullptr) pre->right = root;
      // pre为空，说明是头节点，更新head
      else head = root;
      // 左树遍历过了，将当前节点左边指向pre，并更新pre为当前节点后，遍历右数
      root->left =  pre;
      pre=root;

      dfs(root->right);
    }
    Node* treeToDoublyList(Node* root) {
        if(root==nullptr) return nullptr;
        // 二叉搜索树转排序双向链表
        dfs(root);
        // 最大节点会被pre保存，将head和pre互联即可
        head->left = pre;
        pre->right = head;
        return head;
    }
};