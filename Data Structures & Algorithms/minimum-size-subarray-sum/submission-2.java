class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {
            int tempSum = nums[i];
            if(tempSum < target) {
                for(int j = i+1; j<nums.length; j++) {
                tempSum+=nums[j];
                if(tempSum >= target) {
                    length = Math.min(length, j-i + 1);
                    break;
                }
            }
            } else {
                length = 1;
            }
        }

        if(length == Integer.MAX_VALUE) return 0; else return length;
    }
}