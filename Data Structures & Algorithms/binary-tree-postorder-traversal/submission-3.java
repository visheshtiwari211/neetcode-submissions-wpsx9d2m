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

        while(root != null) {
            if(root.right == null) {
                list.add(root.val);
                root = root.left;
            } else {
                TreeNode pred = root.right;
                while(pred.left != null && pred.left != root) {
                    pred = pred.left;
                }

                if(pred.left == null) {
                    list.add(root.val);
                    pred.left = root;
                    root = root.right;
                } else {
                    pred.left = null;
                    root = root.left;
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
}