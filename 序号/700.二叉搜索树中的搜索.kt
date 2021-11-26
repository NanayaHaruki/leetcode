fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return null
    if (root.`val` == `val`) return root
    return when {
        root.`val` == `val` -> root
        root.`val` > `val` -> searchBST(root.left, `val`)
        else -> searchBST(root.right, `val`)
    }
}