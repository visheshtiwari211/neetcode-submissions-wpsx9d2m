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
        List<TreeNode> q = new ArrayList<>(List.of(root));
        while(!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            List<TreeNode> nextList = new ArrayList<>();
            for(int i = 0; i< q.size(); i++) {
                TreeNode currentNode =  q.get(i);
                if(currentNode.left != null) nextList.add(currentNode.left);
                if(currentNode.right != null) nextList.add(currentNode.right);
                l.add(currentNode.val);
            }
            if(!nextList.isEmpty()) q = nextList; else q = new ArrayList<>();
            res.add(l);
        }
        return res;
    }
}
