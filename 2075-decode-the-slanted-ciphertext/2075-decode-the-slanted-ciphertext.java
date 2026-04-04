class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        int cols= encodedText.length()/rows;
        StringBuilder sb = new StringBuilder();
        for(int start =0;start<cols;start++){
            int i=0;
            int j=start;
            while (i < rows && j < cols) {
                sb.append(encodedText.charAt(i * cols + j));
                i++;
                j++;
            }
        }
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
                end--;
            }
        return sb.substring(0, end + 1);
    }
}