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
    public int goodNodes(TreeNode root) {
        Integer max = Integer.MIN_VALUE;
        return getCount(root, 0, max);
    }

    public int getCount(TreeNode root, int count, int max) {
        if(root == null) return count;

        if(root.val >= max) {
            count++;
            max = root.val;
        }

        count = getCount(root.left, count, max);
        count = getCount(root.right, count, max);

        return count;
    }
}
