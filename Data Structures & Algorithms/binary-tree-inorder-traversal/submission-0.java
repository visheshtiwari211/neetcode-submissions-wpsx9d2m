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
    List<Integer> lists = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        performInOrderTraversal(root);
        return lists;
    }

    public void performInOrderTraversal(TreeNode r) {
        if(r == null) {
            return;
        }
        performInOrderTraversal(r.left);
        lists.add(r.val);
        performInOrderTraversal(r.right);
        return;
    }
}