class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int x: nums) {
            totalSum += x;
        }
        if(totalSum %2 != 0) return false;
        return canMake(nums.length - 1, totalSum/2, nums);
    }

    public boolean canMake(int i, int t, int[] nums) {
        if(t < 0) return false;
        if(t == 0) return true;
        if(i < 0) return false;

        return canMake(i-1, t-nums[i], nums) || canMake(i-1, t, nums); 
    }
}
