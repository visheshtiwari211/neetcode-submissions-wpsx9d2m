class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        
        // Base Case 1: A single node can always reach itself trivially
        if (n == 1) return true;

        // Base Case 2: If any number is 1 in an array with length > 1,
        // gcd(1, x) = 1 for all x, so it can never have a valid traversal edge.
        int maxVal = 0;
        for (int x : nums) {
            if (x == 1) return false;
            if (x > maxVal) maxVal = x;
        }

        // 1. Build the Smallest Prime Factor array up to maxVal
        int[] spf = buildSPF(maxVal);

        // 2. DSU operating strictly on the N indices (0 to n - 1)
        DSU dsu = new DSU(n);

        // firstSeenIndex[p] stores the index of the first number that had prime factor p
        int[] firstSeenIndex = new int[maxVal + 1];
        Arrays.fill(firstSeenIndex, -1);

        // 3. Connect indices that share the same prime factors
        for (int i = 0; i < n; i++) {
            int val = nums[i];

            while (val > 1) {
                int prime = spf[val];

                if (firstSeenIndex[prime] != -1) {
                    // Union current index with the first index that shared this prime
                    dsu.union(i, firstSeenIndex[prime]);
                } else {
                    // Record that index `i` is the first to introduce this prime
                    firstSeenIndex[prime] = i;
                }

                // Strip away all occurrences of this prime factor
                while (val % prime == 0) {
                    val /= prime;
                }
            }
        }

        // 4. All nodes can reach each other iff there is exactly 1 component
        return dsu.components == 1;
    }

    // Precomputing SPF in O(M log log M) time
    private int[] buildSPF(int maxVal) {
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) { // only update if not already set by a smaller prime
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    // Flat array DSU with path compression and union by rank
    static class DSU {
        int[] parent;
        int[] rank;
        int components;

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]); // Path compression
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                // Decrement distinct components count on every successful merge
                components--;
            }
        }
    }
}