class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {

            // Current character is processed
            freq[ch - 'a']--;

            // If already in answer, skip
            if(visited[ch - 'a']) {
                continue;
            }

            // Remove bigger characters if they appear later again
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                char removed = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[removed - 'a'] = false;
            }

            // Add current character
            sb.append(ch);
            visited[ch - 'a'] = true;
        }

        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna