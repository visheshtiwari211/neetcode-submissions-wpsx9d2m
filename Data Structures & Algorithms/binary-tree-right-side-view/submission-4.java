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
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        return getTheRightSideView(root, list, depth);
    }

    public List<Integer> getTheRightSideView(TreeNode root, List<Integer> list, Integer depth) {
        if(root == null) return list;
        if(depth >= list.size()) {
            list.add(root.val);
        }

        getTheRightSideView(root.right, list, depth + 1);
        getTheRightSideView(root.left, list, depth + 1);

        return list;
    }
}
