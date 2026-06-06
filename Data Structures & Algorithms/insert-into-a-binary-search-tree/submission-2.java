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
        TreeNode head = root;
        while(head != null) {
            if(head.left == null && head.val > val) {
            head.left = new TreeNode(val);
            break;
        }

        if(head.right == null && head.val < val) {
            head.right = new TreeNode(val);
            break;
        }

        if(val > head.val) {
            head = head.right;
        } else {
            head = head.left;
        }
        }
        return root;
    }
}