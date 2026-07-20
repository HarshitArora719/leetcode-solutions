class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            char ch = haystack.charAt(i);
            if(ch == needle.charAt(0) && haystack.substring(i,i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna