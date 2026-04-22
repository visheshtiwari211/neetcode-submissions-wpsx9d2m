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
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.push(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.pop();
            TreeNode right = curr.right;
            if(curr.left != null) {
                q.push(curr.left);
            }

            if(curr.right != null) {
                q.push(curr.right);
            }

            curr.right = curr.left;
            curr.left = right;
        }
        return root;
    }
}
