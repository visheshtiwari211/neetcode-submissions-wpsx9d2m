class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSum(nums, target, 0, 0, new ArrayList<>());
        return list;
    }

    public void combinationSum(int[] nums, int target, int i, int sum, List<Integer> l1) {
        if(sum >= target || i >= nums.length) {
            if(sum == target) {
                list.add(new ArrayList(l1));
            }
            return;
        } 

        l1.add(nums[i]);
        sum += nums[i];
        combinationSum(nums, target, i, sum, l1);
        int num = l1.get(l1.size() - 1); 
        sum -= num;
        l1.removeLast();
        combinationSum(nums, target, i + 1, sum, l1);  
        return;
    }
}
