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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Deque<TreeNode> q = new ArrayDeque();
        q.push(root);
        while(!q.isEmpty()) {
            TreeNode top = q.pop();
            list.add(top.val);

            if(top.left != null) {
                q.push(top.left);
            }

            if(top.right != null) {
                q.push(top.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}