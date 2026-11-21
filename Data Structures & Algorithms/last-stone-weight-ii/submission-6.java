class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 1)
            return stones[0];

        if(stones.length == 2) {
            return Math.abs(stones[0]-stones[1]);
        }
        int totalSum = 0;
        for (int x : stones) {
            totalSum += x;
        }

        Boolean[][] memo = new Boolean[stones.length][totalSum];
        int sum = 0;
        if (totalSum % 2 != 0) {
            sum = (int) Math.floor(totalSum / 2);
        } else {
            sum = totalSum / 2;
        }
        if (canMake(stones.length - 1, sum, stones, memo)) {
            return Math.abs(totalSum - 2 * sum);
        }
        for (int i = 1; i < sum; i++) {
            int add = sum + i;
            if (canMake(stones.length - 1, add, stones, memo)) {
                return Math.abs(totalSum - 2 * add);
            }
            int diff = sum - i;
            if (canMake(stones.length - 1, diff, stones, memo)) {
                return Math.abs(totalSum - 2 * diff);
            }
        }
        return 0;
    }

    public boolean canMake(int i, int t, int[] nums, Boolean[][] memo) {
        if (t < 0)
            return false;
        if (t == 0)
            return true;
        if (i < 0)
            return false;

        if(memo[i][t] != null) return memo[i][t];

        if(canMake(i - 1, t - nums[i], nums, memo)) {
            memo[i][t] = true;
            return true;
        }
        if(canMake(i - 1, t, nums, memo)) {
            memo[i][t] = true;
            return true;
        }

        return false;
    }
}