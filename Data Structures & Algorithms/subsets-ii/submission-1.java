class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // list.add(new ArrayList());
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<Integer>();
        getAllSubsets(nums, 0, list1);
        return list;
    }

    public void getAllSubsets(int[] nums, int i, List<Integer> list1) {
        if(i >= nums.length) {
            List<Integer> list2 = new ArrayList<>(list1);
            if(!list.contains(list2)) {
                list.add(list2);
            }
            return;
        }

        getAllSubsets(nums, i+1, list1);
        list1.add(nums[i]);
        getAllSubsets(nums, i+1, list1);
        list1.remove(list1.size()-1);
    }
}
