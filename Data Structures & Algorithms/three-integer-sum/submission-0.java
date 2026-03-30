class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> output = new HashSet();

        for(int i =0; i< nums.length; i++) {
            int target = -(nums[i]);
            int start =i + 1, end = nums.length -1;

            while(start < end) {
                if(start == i) {
                    start++;
                } else if(end == i) {
                    end--;
                } else {
                    int sum = nums[start] + nums[end];
                    if(sum == target) {
                        output.add(Arrays.asList(nums[start], nums[end], nums[i]));
                        start++;
                        end--;
                    } else if(sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return new ArrayList(output);
        
    }
}
