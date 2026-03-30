class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int i =0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1, end = nums.length - 1;

                while(start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];

                    if(sum > target) {
                        end--;
                    } else if(sum < target) {
                        start++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while(start <end && nums[start] == nums[start -1]) {
                            start++;
                        }
                    }
                }
            }
        }

        return list;
    }
}