class Solution {
  fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
    // 原数组构建的root， 数组最大值为根，左边左子树，右边右子树
    // 向原数组增加`val`,返回新节点
    // 向数组末尾添加，要么是顶点，要么是右子树
    // 不断往右子树递归，有比val小的，就变成新节点的左子树
    if(root==null) return TreeNode(`val`)
    if(root.`val`<`val`) return TreeNode(`val`).apply{left = root}
    root.right = insertIntoMaxTree(root.right,`val`)
    return root
  }
}