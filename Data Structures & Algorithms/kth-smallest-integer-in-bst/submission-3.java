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
        return getSmallest(root, k);
    }

    public int getSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        int l = getSmallest(root.left, k);
        if(l!=-1) return l;
        ++lvl;
        if(k == lvl) {
            return root.val;
        } 
        int r = getSmallest(root.right, k);
        if(r!=-1) return r;
        return -1;
    }
}
