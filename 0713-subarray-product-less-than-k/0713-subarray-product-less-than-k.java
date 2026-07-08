class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //using dynamic sliding window
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
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