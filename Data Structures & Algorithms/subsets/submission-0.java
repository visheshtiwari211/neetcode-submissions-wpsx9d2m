class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, i = 0;
        List<Integer> list1 = new ArrayList<>(); 
        getAllSubsets(nums, list1, i);
        return list;
    }

    public void getAllSubsets(int[] nums, List<Integer> list1, int i) {
        if(i >= nums.length) {
            list.add(new ArrayList(list1));
            return;
        }

        list1.add(nums[i]);
        getAllSubsets(nums, list1, i + 1);
        list1.remove(list1.size() - 1);
        getAllSubsets(nums, list1, i + 1);
    }
}
