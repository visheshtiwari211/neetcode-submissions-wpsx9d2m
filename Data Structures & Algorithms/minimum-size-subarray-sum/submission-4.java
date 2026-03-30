class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE, sum = 0;
        int l =0, r= 0;

        while(r<nums.length) {
            sum+=nums[r];
            while(sum>=target) {
                length = Math.min(length, r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }

        if(length == Integer.MAX_VALUE) return 0; else return length;
    }
}