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
    public boolean isValidBST(TreeNode root) {
        return getBst(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public Boolean getBst(TreeNode root, int max, int min) {
        if(root == null) return true;

        if(root.left != null && root.left.val >= root.val) return false;
        if(root.val <= min || root.val >= max) return false;
        if(root.right != null && root.right.val <= root.val) return false;

        return getBst(root.left, root.val, min) && getBst(root.right, max, root.val);
    }
}
