/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    Boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }

        return isBalanced(root.right) && isBalanced(root.left);
    }

    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return 1 + Math.max(left, right);
    }
}
