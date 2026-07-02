class Solution {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int[][] best = new int[m][n];

        for (int[] row : best)
            Arrays.fill(row, -1);

        int startHealth = health - grid.get(0).get(0);

        pq.add(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], h = curr[2];

            if (h < 1) continue;

            if (r == m - 1 && c == n - 1)
                return true;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    int newHealth =
                        h - grid.get(nr).get(nc);

                    if (newHealth > best[nr][nc]) {
                        best[nr][nc] = newHealth;
                        pq.add(new int[]{nr, nc, newHealth});
                    }
                }
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna