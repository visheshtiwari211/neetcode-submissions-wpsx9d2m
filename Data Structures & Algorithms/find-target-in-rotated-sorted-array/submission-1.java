class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        int min = getMin(l, r, nums);

        int left = 0, right = nums.length - 1;
        if(target > nums[right]) {
            right = min - 1;
        } else {
            left = min;
        }

        while(left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int getMin(int l, int r, int[] nums) {
        while(l < r) {
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
