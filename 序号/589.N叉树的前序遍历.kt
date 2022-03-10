
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
	fun preorder(root: Node?): List<Int> {
		if (root == null) return listOf()
		val ans = mutableListOf<Int>()
		ans.add(root.`val`)
		root.children.forEach {
			ans.addAll(preorder(it))
		}
		return ans
	}
}