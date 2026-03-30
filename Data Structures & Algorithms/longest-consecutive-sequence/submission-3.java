class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int i = 0, maxLen = 0;

        while(i<nums.length) {
            if(!set.contains(nums[i] - 1)) {
                int length = 0, min = nums[i];
                while(set.contains(min)) {
                    length++;
                    min = min + 1;
                }
                maxLen = Math.max(maxLen, length);
            }
            i++;
        }

        return maxLen;
    }
}
