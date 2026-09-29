class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        return getAns(nums, dp, n, 2);

    }

    public int getAns(int[] nums, int[] dp, int n, int i) {
        if (i >= n)
            return 0;

        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        getAns(nums, dp, n, i + 1);
        return dp[n-1];
    }
}
