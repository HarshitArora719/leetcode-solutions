class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int[] freq = new int[26];
        int n = word.length();

        for(int i = 0;i < n; i++){
            char ch=word.charAt(i);
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        for(int i = 25; i >= 0; i--){
            ans += freq[i] * ( (25-i) / 8+1);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna