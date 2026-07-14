class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true;
        int sum = 0;
        for(int x: nums) {
            sum += x;
        }
        if(sum % k != 0) return false;
        int total = sum / k;
        int[] sortedArr = Arrays.stream(nums)
                                .boxed()
                                .sorted(Collections.reverseOrder())
                                .mapToInt(Integer::intValue)
                                .toArray();
        for(int x: sortedArr) {
            if(x > total) return false;
        }
        return getP(sortedArr, total, 0, new int[k]);
    }

    public boolean getP(int[] nums, int total, int i, int[] sum) {
        for(int s: sum) {
            if(s > total) return false;
        }

        if(i == nums.length) {
            return true;
        }

        for(int j = 0; j < sum.length; j++) {
            if(j > 0 && sum[j] == sum[j-1]) continue;
            sum[j] += nums[i];
            boolean ans = getP(nums, total, i + 1, sum);
            if(ans) return true;
            sum[j] -= nums[i];
        }

        return false;
    }
}