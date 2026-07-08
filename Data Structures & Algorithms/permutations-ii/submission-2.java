class Solution {
    List<List<Integer>> l2 = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        getP(nums, new boolean[nums.length], new ArrayList());
        return l2;
    }

    public void getP(int[] nums, boolean[] used, List<Integer> l1) {
        if(l1.size() == nums.length) {
            l2.add(new ArrayList(l1));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            used[i] = true;
            l1.add(nums[i]);
            getP(nums, used, l1);
            used[i] = false;
            l1.removeLast();
        }

        return;
    }
}