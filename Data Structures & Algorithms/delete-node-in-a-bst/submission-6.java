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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        TreeNode d1 = root, parent = null;

        while(d1 != null) {
            if(key == d1.val) {
                TreeNode replacement = null;
                if(d1.right != null) {
                     replacement = d1.right;
                     TreeNode curr = replacement;
                     while (curr.left != null) curr = curr.left;
                     curr.left = d1.left;
                } else {
                    replacement = d1.left;
                }
                if(parent == null) return replacement;
            
                if(key < parent.val) {
                  parent.left = replacement;
                } else {
                  parent.right = replacement;
                }
                return root;
            }

            parent = d1;
            if(key < d1.val) {
               d1 = d1.left;
            } else {
               d1 = d1.right;
            }
        }
    
        return root;
    }
}