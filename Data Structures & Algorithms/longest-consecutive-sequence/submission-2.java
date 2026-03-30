class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int i =1, largestCons = 1, length = 1;

        while(i<nums.length) {
            if(nums[i] - nums[i-1] == 1) {
                length++;
            } else if (nums[i] - nums[i-1] == 0) {
                
            }
             else {
                largestCons = Math.max(largestCons, length);
                length = 1;
            }
            largestCons = Math.max(largestCons, length);
            i++;
        }

        return largestCons;
    }
}
