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
        if(root == null) return lists;
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.push(root);
        while(!q.isEmpty()) {
            TreeNode t = q.pop();
            lists.add(t.val);
            if(t.right != null)  {
                q.push(t.right);
            }

            if(t.left != null) {
                q.push(t.left);
            }
        }
        return lists;
    }
}