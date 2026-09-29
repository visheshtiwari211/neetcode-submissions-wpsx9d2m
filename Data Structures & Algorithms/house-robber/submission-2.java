class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = Math.max(second, first + nums[i]);
            first = second;
            second = sum;
        }
        return sum;
    }
}
