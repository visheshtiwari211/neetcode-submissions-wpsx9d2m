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
        getBalanced(root);

        return balanced;
    }

    public int getBalanced(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getBalanced(root.left);
        int right = getBalanced(root.right);

        if(Math.abs(right - left) > 1) {
            balanced = false;
        }

        return 1 + Math.max(left, right);
    }
}
