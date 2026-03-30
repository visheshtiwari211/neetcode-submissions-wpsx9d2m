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
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTransversal(root, k);
        return result;
    }

    public void inOrderTransversal(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inOrderTransversal(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }

        inOrderTransversal(root.right, k);

        return;
    }
}
