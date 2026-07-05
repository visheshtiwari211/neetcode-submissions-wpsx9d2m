class Solution {
    List<List<Integer>> l1 = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        getS(nums, 0, new ArrayList());
        return l1;
    }

    public void getS(int[] nums, int i, List<Integer> l2) {
        if(i >= nums.length) {
            l1.add(new ArrayList(l2));
            return;
        }

        l2.add(nums[i]);
        getS(nums, i + 1, l2);
        l2.removeLast();
        int next = i + 1;
        while(next < nums.length && nums[next] == nums[i]) next++;
        getS(nums, next, l2);
        return; 
    }
}
