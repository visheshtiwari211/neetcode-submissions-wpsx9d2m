class Solution {
    List<List<Integer>> l1 = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        getP(nums, nums.length, set, new ArrayList());
        return l1;
    }

    public void getP(int[] nums, int n, Set<Integer> set, List<Integer> l2) {
        if(l2.size() >= n) {
            if(l2.size() == n) {
                l1.add(new ArrayList(l2));
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            if(set.contains(nums[i])) continue;
            l2.add(nums[i]);
            set.add(nums[i]);
            getP(nums, n, set, l2);
            l2.removeLast();
            set.remove(nums[i]);
        }
        return;
    }
}
