/**
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *Example:
 *Given the sorted array: [-10,-3,0,5,9],
 *One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *      0
 *    / \
 * -3   9
 *  /   /
 *-10  5
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 此题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
   		if(nums.size == 0) return null
   		return findBST(nums,0,nums.size - 1)
    }

    fun findBST(nums:IntArray,start:Int,end:Int) :TreeNode?{
    	if(start > end) return null
    	val middle = start + (end - start) / 2  //不用 （start + end）/2  避免两个int都是很大的数导致相加溢出
    	val root = TreeNode(nums[middle])
    	root.left = findBST(nums,start,middle - 1)
    	root.right = findBST(nums,middle + 1,end)
    	return root
    }
}

class TreeNode(var value:Int = 0) {
	var left:TreeNode? = null
	var right:TreeNode? = null
}
