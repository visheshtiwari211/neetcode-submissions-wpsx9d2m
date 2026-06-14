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
        res = getLevelOrder(root, res, 0);
        return res;
    }

    public List<List<Integer>> getLevelOrder(TreeNode root, List<List<Integer>> list, int lvl) {
        if(root == null) return list;

        if(lvl + 1 > list.size()) {
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
        } else {
            list.get(lvl).add(root.val);
        }

        list = getLevelOrder(root.left, list, lvl + 1);
        list = getLevelOrder(root.right, list, lvl + 1);
        return list;
    }
}
