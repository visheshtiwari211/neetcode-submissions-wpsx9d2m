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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean removeRoot = rln(root, target);
        if(removeRoot) {
            return null;
        }

        return root;
    }

    public boolean rln(TreeNode root, int target) {
        if(root == null) return true;

        boolean left = rln(root.left, target);
        boolean right = rln(root.right, target);

        if(root.left != null && left) {
            root.left = null;
        }
        if(root.right != null && right) {
            root.right = null;
        }

        if(root.val == target && left && right) {
            return true;
        } else {
            return false;
        }
    }
}