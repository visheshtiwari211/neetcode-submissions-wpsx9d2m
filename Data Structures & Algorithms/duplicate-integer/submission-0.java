class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int l = i + 1; l< nums.length; l++) {
                if(nums[i] == nums[l]) {
                    return true;
                }
            }
        }

        return false;
    }
}