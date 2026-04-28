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
    int d = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return d;
    }
    public int getDiameter(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);
        int sum = leftHeight  + rightHeight;

        d = Math.max(d, sum);

        return 1+ Math.max(leftHeight, rightHeight);
    }
}
