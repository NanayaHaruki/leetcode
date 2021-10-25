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
    public String tree2str(TreeNode t) {
    	if(t==null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null || t.right != null) {
            if (t.left == null) {
                sb.append("()");
            } else {
                sb.append("(")
                        .append(tree2str(t.left))
                        .append(")");
            }
            if (t.right != null) {
                sb.append("(")
                        .append(tree2str(t.right))
                        .append(")");
            }
        }
        return sb.toString();
    }
}
