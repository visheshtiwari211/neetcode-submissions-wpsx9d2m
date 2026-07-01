class Solution {
    List<List<Integer>> l1 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, 0, new ArrayList<>());
        return l1;
    }

    public void getCombination(int[] candidates, int target, int sum, int i, List<Integer> l2) {
        if(sum >= target || i >= candidates.length) {
            if(sum == target) {
                l1.add(new ArrayList(l2));
            }
            return;
        }

        
        sum += candidates[i];
        l2.add(candidates[i]);
        getCombination(candidates, target, sum, i + 1, l2);
        sum -= candidates[i];
        l2.removeLast();
        int next = i + 1;
        while(next <= candidates.length - 1 && (candidates[next] == candidates[i])) {next++;}
        getCombination(candidates, target, sum, next, l2);
        return;
    }
}
