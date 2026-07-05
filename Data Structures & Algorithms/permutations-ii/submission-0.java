class Solution {
    List<List<Integer>> l1 = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        getP(nums, new ArrayList(), new boolean[nums.length]);
        return l1;
    }

    private void getP(int[] nums, List<Integer> l2, boolean[] used) {
        if(l2.size() >= nums.length) {
            if(l2.size() == nums.length) {
                l1.add(new ArrayList(l2));
            }
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if((i > 0 && nums[i] == nums[i-1] && !used[i-1]) || used[i]) continue;
            l2.add(nums[i]);
            used[i] = true;
            getP(nums, l2, used);
            l2.removeLast();
            used[i] = false;
        }
        return;
    }
}