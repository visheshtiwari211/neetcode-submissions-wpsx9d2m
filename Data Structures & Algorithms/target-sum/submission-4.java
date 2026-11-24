class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 1. Calculate the sum of all numbers in the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 2. Check impossible edge cases:
        // - |target| > totalSum: can't reach target even if all signs are the same
        // - (totalSum + target) is odd: subsetTarget must be a whole integer
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        // 3. Math reduction: P + N = totalSum and P - N = target => P = (totalSum + target) / 2
        // Now we just need to count subsets that sum up to subsetTarget (P)
        int subsetTarget = (totalSum + target) / 2;

        // 4. dp[s] = number of ways to form sum 's' using the numbers processed so far
        int[] dp = new int[subsetTarget + 1];
        dp[0] = 1; // Base case: 1 way to make sum 0 (pick nothing)

        // 5. Process one number at a time from nums
        for (int num : nums) {
            // Iterate backwards from subsetTarget down to num:
            // - Backwards ensures we read values from BEFORE this num was added (0/1 Knapsack: use each num at most once)
            // - Stopping at 'num' avoids negative indices (s - num < 0) since a number can't form a sum smaller than itself
            for (int s = subsetTarget; s >= num; s--) {
                // New ways to make 's' = (ways without using num) + (ways using num)
                dp[s] += dp[s - num];
            }
        }

        // 6. Return the total number of subsets that sum to subsetTarget
        return dp[subsetTarget];
    }
}