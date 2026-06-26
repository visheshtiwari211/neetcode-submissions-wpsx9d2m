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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode getTree(int[] preorder, int[] inorder, int preorderStr, int preorderEnd, int inorderStr, int inorderEnd) {
        if(preorderStr > preorderEnd) return null;
        if(preorderStr == preorderEnd) return new TreeNode(preorder[preorderStr]);

        TreeNode root = new TreeNode(preorder[preorderStr]);
        int k = inorderStr, size = 0 ;
        while(inorder[k] != root.val) {
            size++;
            k++;
        }

        root.left = getTree(preorder, inorder, preorderStr+1, preorderStr+size, inorderStr, k -1);
        root.right = getTree(preorder, inorder, preorderStr+1+size, preorderEnd, k + 1, inorderEnd);

        return root;
    }
}
