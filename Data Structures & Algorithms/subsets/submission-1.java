class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        getSubsets(nums, 0, new ArrayList<>());
        return list;
    }

    public void getSubsets(int[] nums, int i, List<Integer> l1) {
        if(i >= nums.length) {
            list.add(new ArrayList(l1));
            return;
        }
        l1.add(nums[i]);
        getSubsets(nums, i+1, l1);
        l1.removeLast();
        getSubsets(nums, i+1, l1);
        return;
    }
}
