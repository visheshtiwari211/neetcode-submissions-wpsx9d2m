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
    int lastVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        
        return getInOrderTraversal(root);
    }

    public boolean getInOrderTraversal(TreeNode root) {
        if(root == null) return true;

        boolean first = getInOrderTraversal(root.left);
        if(root.val <= lastVal) return false;
        lastVal = root.val;
        boolean second = getInOrderTraversal(root.right);
        return first && second;
    }
}
