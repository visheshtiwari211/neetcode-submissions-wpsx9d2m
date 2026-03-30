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
    int goodN = 0;
    public int goodNodes(TreeNode root) {
        getNodes(root, Integer.MIN_VALUE);
        return goodN;
    }

    public void getNodes(TreeNode root, int currentGlobalMax) {
        if(root == null) {
            return;
        }

        if(root.val >= currentGlobalMax) {
            goodN++;
            getNodes(root.left, root.val);
            getNodes(root.right, root.val);
        } else {
            getNodes(root.left, currentGlobalMax);
            getNodes(root.right, currentGlobalMax);
        }
    }
}
