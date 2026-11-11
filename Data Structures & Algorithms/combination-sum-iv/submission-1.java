class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] comb = new Integer[target + 1];
        return noOfCombinations(nums, target, comb);
    }

    public int noOfCombinations(int[] nums, int remaining, Integer[] comb) {
        if(remaining < 0) return 0;
        if(remaining == 0) return 1;
        if(comb[remaining] != null) return comb[remaining];

        int totalComb = 0;
        for(int i = 0; i < nums.length; i++) {
            totalComb += noOfCombinations(nums, remaining - nums[i], comb);
        }
        comb[remaining] = totalComb;
        return totalComb;
    }
}