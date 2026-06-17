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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<List<TreeNode>> q = new ArrayDeque<>();
        q.add(List.of(root));
        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            List<TreeNode> nextList = new ArrayList<>();
            List<TreeNode> currentList = q.remove();
            for(int i = 0; i< currentList.size(); i++) {
                TreeNode currentNode = currentList.get(i);
                if(currentNode.left != null) nextList.add(currentNode.left);
                if(currentNode.right != null) nextList.add(currentNode.right);
                l.add(currentNode.val);
            }
            if(!nextList.isEmpty()) q.add(nextList);
            res.add(l);
        }
        return res;
    }
}
