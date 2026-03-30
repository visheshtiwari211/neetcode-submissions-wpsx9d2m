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
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList();
        inOrderTransversal(root, queue);
        while(k>1) {
            queue.remove();
            k--;
        }

        return queue.peek();
    }
}

private void inOrderTransversal(TreeNode root, Queue<Integer> queue) {
    if(root == null) {
        return;
    }

    if(root.left != null) {
        inOrderTransversal(root.left, queue);
    }

    queue.offer(root.val);

    if(root.right != null) {
        inOrderTransversal(root.right, queue);
    }

    return;
}
