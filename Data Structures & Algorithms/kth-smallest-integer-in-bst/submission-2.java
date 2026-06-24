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
    int lvl = 0, e = -1;
    public int kthSmallest(TreeNode root, int k) {
        getSmallest(root, k);
        return e;
    }

    public void getSmallest(TreeNode root, int k) {
        if(root == null) return;

        getSmallest(root.left, k);
        ++lvl;
        if(k == lvl) {
            e = root.val;
        } 
        getSmallest(root.right, k);
        return;
    }
}
