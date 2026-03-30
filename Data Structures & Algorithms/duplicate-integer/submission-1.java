class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int j = 1; j < nums.length; j++) {
            if(nums[j-1] == nums[j]) {
                return true;
            }
        }

        return false;
    }
}