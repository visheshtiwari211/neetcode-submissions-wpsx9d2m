class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } else if(map.size() < 2) {
                map.put(nums[i], 1);
            } else {
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> e = it.next();
                    int newVal = e.getValue() - 1;
                    if (newVal == 0) it.remove();
                    else e.setValue(newVal);
                }
            } 
        }

        List<Integer> ans = new ArrayList<>();
        for (int candidate : map.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == candidate) count++;
            }
            if (count > nums.length / 3) ans.add(candidate);
        }
        return ans;
    }
}