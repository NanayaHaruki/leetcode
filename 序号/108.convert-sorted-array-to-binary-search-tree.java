/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return findBST(nums,0,nums.length - 1);
    }
	
	TreeNode findBST(int[] arr,int start,int end) {
		if(start > end) return null;
		int middle = start + (end - start)/2;
		TreeNode root = new TreeNode(arr[middle]);
		root.left = findBST(arr,start,middle - 1) ;
		root.right = findBST(arr,middle + 1,end);
		return root;
	}
}

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x ;}
}
