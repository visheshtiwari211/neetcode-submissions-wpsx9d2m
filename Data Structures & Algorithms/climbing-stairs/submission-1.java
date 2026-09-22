class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i<=n; i++) {
            map.put(i, -1);
        }
        return getWays(n, map);
    }

    public int getWays(int n, HashMap<Integer, Integer> map) {
        if (n == 2)
            return 2;
        if (n == 1)
            return 1;

        if (map.get(n) == -1) {
            int ways = getWays(n - 1, map) + getWays(n - 2, map);
            map.put(n, ways);
            return ways;
        }
        return map.get(n);
    }
}
