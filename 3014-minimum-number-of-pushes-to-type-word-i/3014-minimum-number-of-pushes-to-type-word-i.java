class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n < 9) return n;
        int a = n/8;
        return 8 * a * (a+1)/2 + n%8 * (a+1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna