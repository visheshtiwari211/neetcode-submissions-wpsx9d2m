class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, l = 0, r = 0;
        while(r < n) {
            nums[l] = nums[r];
            while(r<n && nums[l] == nums[r]) {
                r++;
            }
            l++;
        }
        return l;
    }
}