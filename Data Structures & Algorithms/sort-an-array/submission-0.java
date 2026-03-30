class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int curr = 0;
            while(curr < nums.length - 1) {
                if(nums[curr] > nums[curr+1]) {
                    int temp = nums[curr];
                    nums[curr] = nums[curr + 1];
                    nums[curr + 1] = temp;
                }
                curr++;
            }
        }

        return nums;
    }
}