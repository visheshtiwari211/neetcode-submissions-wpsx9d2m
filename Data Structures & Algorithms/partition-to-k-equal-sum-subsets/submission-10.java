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
        boolean[] check = new boolean[nums.length];
        return getP(sortedArr, total, 0, check, 0, k, 0);
    }

    public boolean getP(int[] nums, int total, int i, boolean[] check, int currSum, int k, int currK) {
        if(currSum == total && currK == k-1) {
            for(boolean b: check) {
                if(!b) return false;
            }
            return true;
        }

        if(i >= nums.length && currK < k-1) {
            i = 0;
        }

        if(currSum == total) {
            currK++;
            currSum = 0;
            i = 0;
        }

        for(int j = i; j< nums.length; j++) {
            if(check[j]) continue; 
            if(currSum + nums[j] <= total) {
                check[j] = true;
                currSum += nums[j];
                boolean ans = getP(nums, total, i+1, check, currSum, k, currK);
                if(ans) return true;
                currSum -= nums[j];
                check[j] = false;
            }
        }
        return false;
    }
}