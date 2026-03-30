class Solution {
    public int firstMissingPositive(int[] nums) {
        int min = 1, max = nums.length;

        for(int i = 0; i<max; i++) {
            while(nums[i] >= min && nums[i] <= max && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int compV = 1;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        compV = max + 1;
        return compV;
    }
}