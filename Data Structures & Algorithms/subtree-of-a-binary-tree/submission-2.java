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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        String s1 = "#";
        String s2 = "#";

        s1 = serializeTree(root, s1);
        s2 = serializeTree(subRoot, s2);
        
        if(s1.contains(s2)) return true;

        return false;
    }

    public String serializeTree(TreeNode root, String s) {
        if(root == null)  {
            return s + "#";
        }

        s += root.val + "#";
        s = serializeTree(root.left, s);
        s = serializeTree(root.right, s);

        return s;
    }
}
