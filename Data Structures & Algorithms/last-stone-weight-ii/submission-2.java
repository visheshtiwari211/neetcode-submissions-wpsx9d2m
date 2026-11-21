class Solution {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 1) return stones[0];
        int totalSum = 0;
        for (int x : stones) {
            totalSum += x;
        }
        int sum = 0;
        if (totalSum % 2 != 0) {
            sum = (int) Math.floor(totalSum / 2);
        } else {
            sum = totalSum/2;
        }
        if (canMake(stones.length - 1, sum, stones)) {
            return Math.abs(totalSum - 2 * sum);
        }
        int step = 0;
        for (int i = 1; i < sum; i++) {
            int add = sum + step;
            if (canMake(stones.length - 1, add, stones)) {
                return Math.abs(totalSum -  2 * add);
            }
            int diff = sum - step;
            if (canMake(stones.length - 1, diff, stones)) {
                return Math.abs(totalSum -  2* diff);
            }
            step++;
        }
        return 0;
    }

    public boolean canMake(int i, int t, int[] nums) {
        if (t < 0)
            return false;
        if (t == 0)
            return true;
        if (i < 0)
            return false;

        return canMake(i - 1, t - nums[i], nums) || canMake(i - 1, t, nums);
    }
}