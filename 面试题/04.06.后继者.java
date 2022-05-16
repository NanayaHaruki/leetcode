class Solution {
  TreeNode ans=null;
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    // bst 找p下一个节点
    // 从root 往下找，p.val 比root.val小就往左找，比root.val大就往右找
    if(root== null) return null;
    if(p.val>=root.val){
      return inorderSuccessor(root.right,p);
    }else{
      TreeNode node = inorderSuccessor(root.left,p);
      if(node==null) return root;
      else return node;
    }
  }
}