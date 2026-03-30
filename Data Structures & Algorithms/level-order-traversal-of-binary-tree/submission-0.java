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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        lvlTransversal(0, root, res);
        return res;
    }

    private void lvlTransversal(int lvl, TreeNode root, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(res.size() == lvl) {
            res.add(new ArrayList<>());
        }
        res.get(lvl).add(root.val);
        lvlTransversal(lvl + 1, root.left, res);
        lvlTransversal(lvl + 1, root.right, res);

        return;    
    }
}
