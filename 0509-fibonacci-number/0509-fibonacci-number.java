class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    public int solve(int n){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = solve(n-2) + solve(n-1);
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna