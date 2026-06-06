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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        insertVal(root, val);
        return root;
    }

    public void insertVal(TreeNode root, int val) {
        if(root == null) return;

        if(root.left == null && root.val > val) {
            root.left = new TreeNode(val);
            return;
        }

        if(root.right == null && root.val < val) {
            root.right = new TreeNode(val);
            return;
        }

        if(val > root.val) {
            insertVal(root.right, val);
        } else {
            insertVal(root.left, val);
        }

        return;
    }
}