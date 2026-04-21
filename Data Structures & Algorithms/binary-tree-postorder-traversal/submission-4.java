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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode curr = dummy;

        while(curr != null) {
            if(curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if(pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    addReverseList(curr.left, pred, list);
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
        
    }

    public void addReverseList(TreeNode from, TreeNode to, List<Integer> list) {
            reverse(from, to);
            TreeNode target = to;
            while(true) {
                list.add(target.val);
                if(target == from) break;
                target = target.right;
            }
            reverse(to, from);
            return;
        }

        public void reverse(TreeNode from, TreeNode to) {
            if(from == to) return;
            TreeNode n1 = from, n2 = from.right;;

            while(n1 != to) {
                TreeNode next = n2.right;
                n2.right = n1;
                n1 = n2;
                n2 = next; 
            }

            return;
        }
}