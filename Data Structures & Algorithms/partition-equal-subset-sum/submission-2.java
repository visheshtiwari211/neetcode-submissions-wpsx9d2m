class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        if (totalSum % 2 != 0)
            return false;
        Boolean[][] memo = new Boolean[nums.length][totalSum / 2 + 1];
        return canMake(nums.length - 1, totalSum / 2, nums, memo);
    }

    public boolean canMake(int i, int t, int[] nums, Boolean[][] memo) {
        // Base cases
        if (t == 0) return true;
        if (i < 0 || t < 0) return false;

        // Return cached result if already computed
        if (memo[i][t] != null) {
            return memo[i][t];
        }

        // Choice 1: Exclude nums[i]
        boolean exclude = canMake(i - 1, t, nums, memo);

        // Choice 2: Include nums[i] (only valid if current item fits)
        boolean include = false;
        if (t >= nums[i]) {
            include = canMake(i - 1, t - nums[i], nums, memo);
        }

        // Cache and return result for current state (i, t)
        return memo[i][t] = (exclude || include);
    }
}
