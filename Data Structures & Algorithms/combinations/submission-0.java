class Solution {
    List<List<Integer>> l2 = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, new ArrayList(), 1);
        return l2;
    }

    public void getCombine(int n, int k, List<Integer> l1, int i) {
        if(l1.size() >= k || i > n) {
            if(l1.size() ==k) {
                l2.add(new ArrayList(l1));
            }
            return;
        }

        l1.add(i);
        getCombine(n, k, l1, i + 1);
        l1.removeLast();
        getCombine(n, k, l1, i + 1);
    }
}