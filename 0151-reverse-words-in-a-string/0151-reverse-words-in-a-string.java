class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();

        int r = s.length()-1;

        while(r >= 0){

            while(r >= 0 && s.charAt(r)==' ')
                r--;

            int end = r;

            while(r >= 0 && s.charAt(r)!=' ')
                r--;

            sb.append(s.substring(r+1,end+1));

            if(r > 0)
                sb.append(" ");
        }
        
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna