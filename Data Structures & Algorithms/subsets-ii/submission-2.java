class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // list.add(new ArrayList());
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<Integer>();
        getAllSubsets(nums, 0, list1);
        return list;
    }

    public void getAllSubsets(int[] nums, int start, List<Integer> list1) {
        list.add(new ArrayList<>(list1));

    for (int i = start; i < nums.length; i++) {
        // Skip duplicate elements
        if (i > start && nums[i] == nums[i - 1]) continue;

        list1.add(nums[i]);
        getAllSubsets(nums, i + 1, list1);
        list1.remove(list1.size() - 1);
    }
    }
}
