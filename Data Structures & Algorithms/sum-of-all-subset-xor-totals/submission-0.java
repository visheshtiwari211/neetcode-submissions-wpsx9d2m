class Solution {
    public int subsetXORSum(int[] nums) {
        int xor = getSubset(nums, 0, 0);
        return xor;
    }

    public int getSubset(int[] nums, int xor, int i) {
        if(i >= nums.length) return xor;

        int left = getSubset(nums, xor, i + 1);
        xor = xor ^ nums[i];
        int right = getSubset(nums, xor, i + 1);
        return left+ right;
    }
}