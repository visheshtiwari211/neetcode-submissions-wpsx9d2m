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
    int globalDiff = 0;
    public boolean isBalanced(TreeNode root) {
        diffLvl(root);
        if(globalDiff > 1) {
            return false;
        }
        return true;
    }

    public int diffLvl(TreeNode root) {
        if(root == null) {
            return 0;
        }   

        int leftLvl = diffLvl(root.left) + 1;
        int rightLvl = diffLvl(root.right) + 1;

        int diff = Math.abs(leftLvl - rightLvl);
        globalDiff = Math.max(globalDiff, diff);
        
        int biggerLvl = Math.max(leftLvl, rightLvl);
        return biggerLvl;
    }
}
