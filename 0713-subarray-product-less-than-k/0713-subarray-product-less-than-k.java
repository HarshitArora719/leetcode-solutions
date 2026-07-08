class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //using dynamic sliding window
        if(k <= 1) return 0; // base case
        int left = 0;
        int right = 0;
        int count = 0;
        long product = 1;// using long to avoid int overflow
        while(right < nums.length){
            product *= nums[right];
            while(product >= k){
                product = product / nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna