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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        storeNodeInHashMap(root, 0);
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> list1 = entry.getValue();
            int size = list1.size();
            int v = list1.get(size - 1);
            list.add(v);
        }

        return list;
    }

    public void storeNodeInHashMap(TreeNode root, int lvl) {
        if(root == null) {
            return;
        }

        storeNodeInHashMap(root.left, lvl + 1);
        storeNodeInHashMap(root.right, lvl + 1);

        if(map.containsKey(lvl)) {
            List<Integer> list = map.get(lvl);
            list.add(root.val);
            map.put(lvl, list);
        }else {
            map.put(lvl, new ArrayList<>());
            List<Integer> list = map.get(lvl);
            list.add(root.val);
            map.put(lvl, list);
        }
        return;
    }
}
