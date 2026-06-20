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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        q.add(root);
        int size = q.size();
        while(!q.isEmpty()) {
            if(size == 0) size = q.size();
            TreeNode head = q.remove();
            if(size == 1) {
                l.add(head.val);
            }
            size--;
            if(head.left != null) q.add(head.left);
            if(head.right != null) q.add(head.right);
        }

        return l;
    }
}
