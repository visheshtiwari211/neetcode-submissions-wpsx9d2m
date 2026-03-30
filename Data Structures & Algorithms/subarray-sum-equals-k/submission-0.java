class Solution {
    public int subarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap();
       int sum = 0;
       int result = 0;

       map.put(0, 1);

       for(int j: nums) {
        sum+=j;
        int diff = sum - k;
        int count = map.getOrDefault(diff, 0);
        result += count;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
       } 

       return result;
    }
}