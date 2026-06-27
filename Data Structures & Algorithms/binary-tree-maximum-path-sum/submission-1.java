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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return maxPath;
    }

    public int getMax(TreeNode root) {
        if(root == null) return 0;

        int left = getMax(root.left);
        int right = getMax(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int sum = left + right + root.val;
        maxPath = Math.max(maxPath, sum);

        int maxC = Math.max(left, right);
        return root.val + maxC;
    }
}
