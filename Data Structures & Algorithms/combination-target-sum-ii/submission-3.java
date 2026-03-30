class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list1 = new ArrayList<>();
        getCombinationSum(candidates, target, 0, 0, list1);
        return list;
    }

    public void getCombinationSum(int[] candidates, int target, int sum, int i, List<Integer> list1) {
        if(sum == target) {
            list.add(new ArrayList<>(list1));
            return;
        }

        if(sum > target || i >= candidates.length) {
            return;
        }

        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j-1] == candidates[j]) continue;

            list1.add(candidates[j]);
            getCombinationSum(candidates, target, sum + candidates[j], j + 1, list1);
            list1.remove(list1.size()-1);
        }
    }
}
