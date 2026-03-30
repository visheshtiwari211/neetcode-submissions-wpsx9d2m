class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;

        while(left < right) {
            if(nums[right] == val) {
                right--;
            }
            if(nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left++;
        }
        int s = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == val) {
                break;
            }
            s++;
        }

        return s;
    }
}