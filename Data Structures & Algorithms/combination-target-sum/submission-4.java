class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list1 = new ArrayList<>();
        getCombinationSum(list1, 0, 0, nums, target);
        return list;
    }

    public void getCombinationSum(List<Integer> list1, int i, int sum, int[] nums, int target) {
        if(sum == target) {
            list.add(new ArrayList<>(list1));
            return;
        }

        if(sum > target || i >= nums.length) {
            return;
        }

        list1.add(nums[i]);
        getCombinationSum(list1, i, sum + nums[i], nums, target);
        list1.remove(list1.size() - 1);
        getCombinationSum(list1, i + 1, sum, nums, target);
    }
}
