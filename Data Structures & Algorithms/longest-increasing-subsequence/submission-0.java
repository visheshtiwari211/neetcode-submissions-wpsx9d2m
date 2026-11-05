class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] g = new int[nums.length];
        g[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxGi = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    maxGi = Math.max(maxGi, g[j]);
                }
            }
            if (maxGi == Integer.MIN_VALUE)
                g[i] = 1;
            else
                g[i] = 1 + maxGi;
        }
        int globalGi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            globalGi = Math.max(globalGi, g[i]);
        }

        return globalGi;
    }
}
