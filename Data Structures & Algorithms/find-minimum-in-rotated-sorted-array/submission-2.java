class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int lastValid = 0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            lastValid = nums[mid];
            if(nums[mid] >= nums[l] && nums[mid] >= nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return lastValid;
    }
}
