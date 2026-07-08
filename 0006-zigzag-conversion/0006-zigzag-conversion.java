class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int currentRow = 0;
        boolean goingDown = false;
        for(int i=0;i<s.length();i++) {
            arr[currentRow] += s.charAt(i);
            if (currentRow == numRows-1 || currentRow == 0) {
                goingDown = !goingDown;
            }
            if (goingDown) {
                currentRow += 1;
            }
            else {
                currentRow -= 1;
            }
        }
        String ans = "";
        for(String ss: arr) {
            ans += ss;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna