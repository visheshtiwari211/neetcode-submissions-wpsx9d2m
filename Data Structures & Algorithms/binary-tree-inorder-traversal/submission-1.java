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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        performInOrderTraversal(root, lists);
        return lists;
    }

    public void performInOrderTraversal(TreeNode r, List<Integer> lists) {
        if(r == null) {
            return;
        }
        performInOrderTraversal(r.left, lists);
        lists.add(r.val);
        performInOrderTraversal(r.right, lists);
        return;
    }
}