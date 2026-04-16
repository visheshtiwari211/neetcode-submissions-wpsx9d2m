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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<Integer>();
        doPreOrder(root, lists);
        return lists;
    }

    public void doPreOrder(TreeNode root, List<Integer> lists) {
        if(root == null) {
            return;
        }

        lists.add(root.val);
        doPreOrder(root.left, lists);
        doPreOrder(root.right, lists);

        return;
    }
}