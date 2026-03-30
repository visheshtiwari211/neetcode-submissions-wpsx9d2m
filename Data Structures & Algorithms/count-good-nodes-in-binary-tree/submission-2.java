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
    int globalMax = Integer.MIN_VALUE, goodN = 0;
    public int goodNodes(TreeNode root) {
        getNodes(root, globalMax);
        return goodN;
    }

    public void getNodes(TreeNode root, int currentGlobalMax) {
        if(root == null) {
            return;
        }

        if(root.val >= globalMax) {
            goodN++;
            globalMax = root.val;
            getNodes(root.left, globalMax);
            globalMax = root.val;
            getNodes(root.right, globalMax);
        } else {
            getNodes(root.left, globalMax);
            globalMax = currentGlobalMax;
            getNodes(root.right, globalMax);   
        }
    }
}
