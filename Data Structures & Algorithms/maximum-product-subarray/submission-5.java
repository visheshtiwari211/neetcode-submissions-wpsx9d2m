class Solution {
    int globalMax = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        globalMax = nums[0];
        int prevMin = nums[0], prevMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp1 = 0, temp2 = 0;

            int x = nums[i];

            if (x < 0) {
                temp1 = prevMin * x;
                temp2 = prevMax * x;
            } else {
                temp1 = prevMax * x;
                temp2 = prevMin * x;
            }

            prevMax = Math.max(x, temp1);
            prevMin = Math.min(x, temp2);

            globalMax = Math.max(globalMax, prevMax);
        }
        return globalMax;
    }

    public void getMaxProduct(int[] nums, int i, int prevMin, int prevMax) {
        if (i >= nums.length)
            return;

        int currMax = 0, currMin = 0, temp1 = 0, temp2 = 0;

        int x = nums[i];

        if (x < 0) {
            temp1 = prevMin * x;
            temp2 = prevMax * x;
        } else {
            temp1 = prevMax * x;
            temp2 = prevMin * x;
        }

        currMax = Math.max(x, temp1);
        currMin = Math.min(x, temp2);

        globalMax = Math.max(globalMax, currMax);
        getMaxProduct(nums, i + 1, currMin, currMax);
        return;
    }
}
