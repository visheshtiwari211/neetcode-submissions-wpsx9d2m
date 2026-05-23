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
        

        return fromKmp(s1, s2);
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

    public boolean fromKmp(String s, String p) {
        int[] lps = buildLps(p);
        int n1 = s.length();
        int n2 = p.length();
        int i = 0, m= 0;

        while(i < n1) {
            if(s.charAt(i) == p.charAt(m)) {
                i++;
                m++;
                if(m == n2) return true;
            } else {
                if(m != 0) m = lps[m-1];
                else i++;
            }
        }

        return false;
    }

    public int[] buildLps(String p) {
        int n = p.length();
        int[] lps = new int[n];
        lps[0] = 0;

        int i = 1, len = lps[i-1];
        while(i < n) {
            if(p.charAt(i) == p.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len-1];
                }
            }
        }
        return lps;
    }
}
