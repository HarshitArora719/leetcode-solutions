class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);

        // Create connections
        for (int i = 1; i < n; i++) {
            // If adjacent nodes can have an edge
            if (nums[i] - nums[i - 1] <= maxDiff) {
                dsu.union(i, i - 1);
            }
        }

        boolean[] ans = new boolean[queries.length];

        // Answer queries
        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = dsu.find(u) == dsu.find(v);
        }

        return ans;
    }


    class DSU {

        int[] parent;
        int[] size;


        DSU(int n) {

            parent = new int[n];
            size = new int[n];


            // Initially every node is its own parent
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }


        // Find the leader of a group
        int find(int x) {

            // x is already the leader
            if (parent[x] == x) {
                return x;
            }


            // Path compression
            parent[x] = find(parent[x]);

            return parent[x];
        }


        // Merge two groups
        void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);

            // Already in same group
            if (parentA == parentB) {
                return;
            }

            // Attach smaller group to larger group
            if (size[parentA] < size[parentB]) {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];

            } else {
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna