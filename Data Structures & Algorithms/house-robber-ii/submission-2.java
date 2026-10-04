class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        int sum1 = Math.max(first, second);
        for (int i = 2; i < n - 1; i++) {
            sum1 = Math.max(second, first + nums[i]);
            first = second;
            second = sum1;
        }
        int sum2 = 0;
        first = 0; second = nums[1];
        for (int i = 2; i < n; i++) {
            sum2 = Math.max(second, first + nums[i]);
            first = second;
            second = sum2;
        }

        return Math.max(sum1, sum2);
    }
}
