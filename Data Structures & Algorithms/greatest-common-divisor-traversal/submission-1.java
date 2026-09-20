class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // Edge Case 1: A single element can always reach itself
        if (nums.length == 1) return true;

        // Edge Case 2: In an array of size > 1, any 1 has gcd(1, x) = 1, so it cannot connect to anything
        for (int x : nums) {
            if (x == 1) return false;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        DSU dsu = new DSU(list);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> l1 = getPrimeFactors(nums[i]);
            for (int p : l1) {
                // union handles find internally and avoids redundant operations
                dsu.union(nums[i], p);
            }
        }

        // Verify that all elements share the same root
        int parent = dsu.find(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (parent != dsu.find(nums[i])) return false;
        }

        return true;
    }

    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        if (n % 2 == 0) {
            factors.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        for (int d = 3; d * d <= n; d += 2) {
            if (n % d == 0) {
                factors.add(d);
                while (n % d == 0) {
                    n /= d;
                }
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    class DSU {
        Map<Integer, Integer> parent;
        Map<Integer, Integer> rank;

        public DSU(List<Integer> list) {
            parent = new HashMap<>();
            rank = new HashMap<>();
            for (int val : list) {
                parent.put(val, val);
                rank.put(val, 0);
            }
        }

        public int find(int i) {
            // Register nodes (like prime factors) on the fly if not present
            if (!parent.containsKey(i)) {
                parent.put(i, i);
                rank.put(i, 0);
                return i;
            }
            if (parent.get(i) != i) {
                parent.put(i, find(parent.get(i))); // path compression
            }
            return parent.get(i);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                int rankX = rank.get(rootX);
                int rankY = rank.get(rootY);

                if (rankX < rankY) {
                    parent.put(rootX, rootY);
                } else if (rankX > rankY) {
                    parent.put(rootY, rootX);
                } else {
                    parent.put(rootY, rootX);
                    rank.put(rootX, rankX + 1);
                }
            }
        }
    }
}