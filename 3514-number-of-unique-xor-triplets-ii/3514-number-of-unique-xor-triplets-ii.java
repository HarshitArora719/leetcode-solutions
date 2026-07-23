class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        // Store all possible pair XORs
        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }

        boolean[] ans = new boolean[2048];

        // Add third element
        for (int i = 0; i < 2048; i++) {
            if (pair[i]) {
                for (int x : nums) {
                    ans[i ^ x] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna