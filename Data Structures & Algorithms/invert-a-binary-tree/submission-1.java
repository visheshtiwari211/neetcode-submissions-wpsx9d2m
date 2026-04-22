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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode curr = root;
        getInvertTree(curr);
        return root;
    }

    public void getInvertTree(TreeNode curr) {
        if(curr == null) return;

        getInvertTree(curr.right);
        getInvertTree(curr.left);

        TreeNode temp = curr.right;
        curr.right = curr.left;
        curr.left = temp;

        return;
    }
}
