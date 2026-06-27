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
    public int rob(TreeNode root) {
        if(root == null) return 0;

        int[] ans = getRob(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] getRob(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] left = getRob(root.left);
        int[] right = getRob(root.right);

        int[] d = new int[2];

        d[0] = root.val + left[1] + right[1];
        d[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return d;
    }
}