class Solution {
    int minSum = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int k) {
        int maxSum = 0, max = Integer.MIN_VALUE, n = nums.length;
        for(int num: nums) {
            maxSum += num;
            max = Math.max(max, num);
        } 

        int l = max, r = maxSum, lastValid = 0;
        while(l <= r) {
            int mid = l + (r-l)/2, sum = 0, count = 0;
            for(int i = 0; i<n; i++) {
                if(sum + nums[i] > mid) {
                    count++;
                    sum = 0;
                    if(count > k) break;
                }
                sum += nums[i];
            }
            if(sum > 0) {
                count++;
            }

            if(count <= k) {
                lastValid = mid;
                r= mid -1;
            } else {
                l = mid + 1;
            }

        }
        return lastValid;
    }
}