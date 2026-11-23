class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for(int num: nums) {
            s += num;
        }
        Integer[][] memo = new Integer[nums.length][2*s+1];
        return getWays(nums, target, 0, 0, memo, s);
    }

    public int getWays(int[] nums, int target, int i, int sum, Integer[][] memo, Integer totalSum) {
        if(i>=nums.length) {
            if(sum == target) return 1; else return 0;
        }
        if(memo[i][sum + totalSum] != null) return memo[i][sum + totalSum];
        int ways = 0;
        ways+=getWays(nums, target, i + 1, sum + nums[i], memo, totalSum);
        ways+=getWays(nums, target, i + 1, sum - nums[i], memo, totalSum);
        memo[i][sum + totalSum] = ways;
        return ways;
    }
}
