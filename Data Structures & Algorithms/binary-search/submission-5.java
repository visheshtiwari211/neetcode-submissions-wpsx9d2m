class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 ){
            if(nums[0] == target) {
                return 0;   
            } else {
                return -1;
            }
        }

        int l = 0, r = nums.length - 1;

        while(l<=r) {
            if(nums[l] == target) return l;
            if(nums[r] == target) return r;
            int mid = (r+l)/2;

            if(target > nums[mid]) {
                l = mid + 1;
            } else if(target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
