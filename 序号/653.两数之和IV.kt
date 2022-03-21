class Solution {
	val dict = sortedSetOf<Int>()
	/*---------------遍历完再找 ---------------------*/
	fun findTarget(root: TreeNode?, k: Int): Boolean {
		dfs(root)
		for (i in dict) {
			if (i!=k/2 && dict.contains(k - i)) return true
		}
		return false
	}

	fun dfs(node: TreeNode?) {
		if (node == null) return
		dict.add(node.`val`)
		dfs(node.left)
		dfs(node.right)
	}

/*-----------------边遍历边找-----------------*/
	fun findTarget(root: TreeNode?, k: Int): Boolean {
		if (root == null) return false
		val value = root.`val`
		if (dict.contains(k - value)) return true
		dict.add(value)
		return findTarget(root.left, k) || findTarget(root.right, k)
	}
}